package com.choujiang.service;

import com.choujiang.mapper.UserRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserRecordService
 * @Description
 * @createTime 2022/06/15 14:55
 **/
@Service
public class UserRecordService {

    @Resource
    private UserRecordMapper userRecordMapper;
}
