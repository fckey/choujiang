package com.choujiang.service;

import com.choujiang.domain.DrawRecord;
import com.choujiang.domain.DrawRecordExample;
import com.choujiang.domain.UserRecord;
import com.choujiang.domain.UserRecordExample;
import com.choujiang.exception.BusinessException;
import com.choujiang.exception.BusinessExceptionCode;
import com.choujiang.mapper.DrawRecordMapper;
import com.choujiang.mapper.UserRecordMapper;
import com.choujiang.req.DrawRecordQueryReq;
import com.choujiang.req.DrawRecordReq;
import com.choujiang.resp.DrawRecordQueryResp;
import com.choujiang.resp.PageResp;
import com.choujiang.resp.UserLoginResp;
import com.choujiang.util.ConstsUtil;
import com.choujiang.util.CopyUtil;
import com.choujiang.util.LoginUserContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawRecordService
 * @Description
 * @createTime 2022/06/14 17:10
 **/
@Service
public class DrawRecordService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserRecordMapper userRecordMapper;
    @Resource
    private DrawRecordMapper drawRecordMapper;

    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/15 14:41
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
      * @description: 列出当前用户某次活动的所抽的签
      * @Date: 2022/6/15 15:00
      * @params:
      * @return:
      **/
    public PageResp<DrawRecordQueryResp> list(DrawRecordQueryReq req) {
        // 获取用户身份
        UserLoginResp user = LoginUserContext.getUser();
        // 构造查询条件
        UserRecordExample userRecordExample = new UserRecordExample();
        UserRecordExample.Criteria criteria = userRecordExample.createCriteria();
        criteria.andDrawIdEqualTo(req.getDrawId());
        // 如果不是管理员
        if(Objects.equals(user.getUserRole(), ConstsUtil.USER_IDENTIFIER)){
            criteria.andUserIdEqualTo(user.getUserId());
        }
        // 分页逻辑
        PageHelper.startPage(req.getPage(), req.getSize());
        List<UserRecord> userRecordList = userRecordMapper.selectByExample(userRecordExample);
        PageInfo<UserRecord> pageInfo = new PageInfo<>(userRecordList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        // 构造结果
        List<DrawRecordQueryResp> list = new ArrayList<>();
        // 进行封装结果集
        for (UserRecord userRecord : userRecordList) {
            DrawRecordQueryResp resp = CopyUtil.copy(userRecord, DrawRecordQueryResp.class);
            // 按照id查询签
            DrawRecord drawRecord = drawRecordMapper.selectByPrimaryKey(userRecord.getRecordId());
            // 将两个签东西进行封装
            resp.setRecordRand(drawRecord.getRecordRand());
            resp.setRecordStatus(drawRecord.getRecordStatus());
            // 将封装好的东西放到结果集
            list.add(resp);
        }
        // 构造分页对象
        PageResp<DrawRecordQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }
}
