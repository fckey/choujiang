package com.choujiang.service;

import com.choujiang.mapper.DrawRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawRecordService
 * @Description
 * @createTime 2022/06/14 17:10
 **/
@Service
public class DrawRecordService {
    @Resource
    private DrawRecordMapper drawRecordMapper;
}
