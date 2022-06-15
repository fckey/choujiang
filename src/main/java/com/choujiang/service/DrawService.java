package com.choujiang.service;

import com.choujiang.domain.Draw;
import com.choujiang.domain.DrawExample;
import com.choujiang.domain.DrawRecord;
import com.choujiang.mapper.DrawMapper;
import com.choujiang.mapper.DrawRecordMapper;
import com.choujiang.mapper.OrganizationMapper;
import com.choujiang.req.DrawQueryReq;
import com.choujiang.req.DrawSaveReq;
import com.choujiang.resp.DrawQueryResp;
import com.choujiang.resp.PageResp;
import com.choujiang.util.ConstsUtil;
import com.choujiang.util.CopyUtil;
import com.choujiang.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

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
                // 先把其他所有的活动都设置为无效
                setAllDrawInValid();
                // 设置到对象中
                draw.setDrawNum(quotas);
                // 插入数据,使用了组件自增的策略，之后会获取到数据
                drawMapper.updateByPrimaryKeySelective(draw);
                // 生成签
                generatorDrawRecords(quotas, req.getDrawLuck(), draw.getDrawId());
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
      * @description: 设置所有的字段都失效
      * @Date: 2022/6/15 21:40
      * @params:
      * @return:
      **/
    public void setAllDrawInValid(){
        DrawExample drawExample = new DrawExample();
        DrawExample.Criteria criteria = drawExample.createCriteria();
        criteria.andDrawValidEqualTo(ConstsUtil.DRAW_VALID);

        List<Draw> draws = drawMapper.selectByExample(drawExample);
        for (Draw draw : draws) {
            draw.setDrawValid(0);
            drawMapper.insert(draw);
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
            if( drawLuck-- > 0) drawRecord.setRecordStatus(1);
            // 插入数据
            drawRecordMapper.insert(drawRecord);
        }
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
        if(ObjectUtils.isEmpty(req.getDrawDesc())) criteria.andDrawDescLike("%" + req.getDrawDesc() + "%");
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


    public Draw queryValidDraw() {
        DrawExample drawExample = new DrawExample();
        DrawExample.Criteria criteria = drawExample.createCriteria();
        // 查询有效签
        criteria.andDrawValidEqualTo(ConstsUtil.DRAW_VALID);
        List<Draw> draws = drawMapper.selectByExample(drawExample);
        return draws.get(0);
    }
}
