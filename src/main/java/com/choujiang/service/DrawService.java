package com.choujiang.service;

import com.choujiang.domain.*;
import com.choujiang.exception.BusinessException;
import com.choujiang.exception.BusinessExceptionCode;
import com.choujiang.mapper.DrawMapper;
import com.choujiang.mapper.DrawRecordMapper;
import com.choujiang.mapper.OrganizationMapper;
import com.choujiang.mapper.UserRecordMapper;
import com.choujiang.req.DrawQueryReq;
import com.choujiang.req.DrawRecordReq;
import com.choujiang.req.DrawSaveReq;
import com.choujiang.resp.DrawQueryResp;
import com.choujiang.resp.PageResp;
import com.choujiang.resp.UserLoginResp;
import com.choujiang.util.ConstsUtil;
import com.choujiang.util.CopyUtil;
import com.choujiang.util.LoginUserContext;
import com.choujiang.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawService
 * @Description
 * @createTime 2022/06/14 15:28
 **/
@Service
public class DrawService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Resource
    private DrawMapper drawMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private DrawRecordMapper drawRecordMapper;

    @Resource
    private UserRecordMapper userRecordMapper;

    @Resource
    private SnowFlake snowFlake;

    public void save(DrawSaveReq req) {
        // 首先要
        Draw draw = CopyUtil.copy(req, Draw.class);
        if(ObjectUtils.isEmpty(req.getDrawId())) {
            // 添加
            Draw drawdb = selectByDesc(req.getDrawDesc());
            // 判断是否有描述冲突
            if (ObjectUtils.isEmpty(drawdb)) {
                // 获得所有企业的配额
                int quotas = getQuotas(req.getOrgs());
                // 生成签
                generatorDrawRecords(quotas, req.getDrawLuck(), req.getDrawId());
            }
        } else{
            // 更新
            draw.setDrawLuck(null);
            draw.setDrawNum(null);
            // 更新数据
            drawMapper.updateByPrimaryKeySelective(draw);
        }
    }
    /**
      * @author: fangshaolei
      * @description:  按照描述来查询该数据表中的字段
      * @Date: 2022/6/14 15:43
      * @params: 
      * @return: 
      **/

    public Draw selectByDesc(String desc){
        DrawExample  drawExample = new DrawExample();
        DrawExample.Criteria criteria = drawExample.createCriteria();
        criteria.andDrawDescEqualTo(desc);
        List<Draw> draws = drawMapper.selectByExample(drawExample);
        if(CollectionUtils.isEmpty(draws)) return null;
        return draws.get(0);
    }
    /**
      * @author: fangshaolei
      * @description: 查询该字段中添加企业总的配额
      * @Date: 2022/6/14 15:43
      * @params: 
      * @return: 
      **/
    public int getQuotas(List<Integer> ids){
        int sum = 0;
        for (Integer id : ids) {
            sum += organizationMapper.selectByOrganizationQuotas(id);
        }
        return sum;
    }
    /**
      * @author: fangshaolei
      * @description: 新建活动之后生成签
      * @Date: 2022/6/14 15:52
      * @params:
      * @return:
      **/
    private void generatorDrawRecords(int quotas, Integer drawLuck, Integer drawId) {
        for (int i = 0; i < quotas; i++) {
            DrawRecord drawRecord = new DrawRecord();
            // 设置当前签所归属的活动
            drawRecord.setDrawId(drawId);
            // 生成随机签序列号
            int rand = (int)(snowFlake.nextId() % 2147483647);
            drawRecord.setRecordRand(rand);
            // 标记固定数量的有效签
            if( drawLuck-- >= 0) drawRecord.setRecordStatus(1);
            // 插入数据
            drawRecordMapper.insert(drawRecord);
        }
    }
    /**
      * @author: fangshaolei
      * @description: 生成单一的随机签
      * @Date: 2022/6/14 17:04
      * @params:
      * @return:
      **/
    public synchronized DrawRecord randomSingletonDrawGenerator(DrawRecordReq req) {
        DrawRecord drawRecord = null;
        // 查看对应的状态，锁定的状态就是理解为签已经被展示的状态
        if(req.getStatus().equals(ConstsUtil.DRAW_RECORD_LOCKED)){
            // 查出所有没有被抽的签
            DrawRecordExample drawRecordExample = new DrawRecordExample();
            DrawRecordExample.Criteria criteria = drawRecordExample.createCriteria();
            criteria.andRecordStatusEqualTo(0);
            // 一定指的是某次活动
            criteria.andDrawIdEqualTo(req.getDrawId());
            // 查询出该次活动所有的签
            List<DrawRecord> drawRecords = drawRecordMapper.selectByExample(drawRecordExample);
            // rand
            int i = new Random().nextInt(drawRecords.size());
            // 查询
            drawRecord = drawRecords.get(i);
            // 状态改为1 ， 表示当前为锁定的状态
            DrawRecord record = new DrawRecord();
            // 设置签的id
            record.setRecordId(drawRecord.getRecordId());
            // 修改状态为锁定状态
            record.setRecordIssused(ConstsUtil.DRAW_RECORD_LOCKED);
            // 更新数据库
            drawRecordMapper.updateByPrimaryKeySelective(record);
        }else if(req.getStatus().equals(ConstsUtil.DRAW_RECORD_FIX)){
            // 确定了抽取那个签
            // Todo. 修改签的状态
            DrawRecord record = new DrawRecord();
            record.setRecordId(req.getRecordId());
            // 修改为确定的状态
            record.setRecordIssused(ConstsUtil.DRAW_RECORD_FIX);
            drawRecordMapper.updateByPrimaryKeySelective(record);
            // ToDo. 将数据写到中间表
            UserLoginResp user = LoginUserContext.getUser();
            UserRecord userRecord = new UserRecord();
            userRecord.setUserId(user.getUserId());
            userRecord.setDrawId(req.getDrawId());
            userRecord.setRecordId(req.getDrawId());
            userRecord.setDate(new Date());
            userRecordMapper.insert(userRecord);
        }else{
            throw new BusinessException(BusinessExceptionCode.DRAW_RECORD_STATUS_ILLEGAL);
        }
        return drawRecord;
    }
    /**
      * @author: fangshaolei
      * @description: 列出所有的活动
      * @Date: 2022/6/14 16:41
      * @params: 
      * @return: 
      **/
    public PageResp<DrawQueryResp> list(DrawQueryReq req) {
        DrawExample drawExample = new DrawExample();
        DrawExample.Criteria criteria  = drawExample.createCriteria();
        if(ObjectUtils.isEmpty(req.getDrawDesc())) criteria.andDrawDescLike(req.getDrawDesc());
        // 设置分页逻辑
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Draw> draws = drawMapper.selectByExample(drawExample);
        PageInfo<Draw> pageInfo = new PageInfo<>(draws);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        // 批量赋值
        List<DrawQueryResp> list = CopyUtil.copyList(draws, DrawQueryResp.class);

        PageResp<DrawQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }



}
