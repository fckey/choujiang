package com.choujiang.service;

import com.choujiang.domain.User;
import com.choujiang.domain.UserExample;
import com.choujiang.exception.BusinessException;
import com.choujiang.exception.BusinessExceptionCode;
import com.choujiang.mapper.OrganizationMapper;
import com.choujiang.mapper.UserMapper;
import com.choujiang.req.UserLoginReq;
import com.choujiang.req.UserQueryReq;
import com.choujiang.req.UserResetPasswordReq;
import com.choujiang.req.UserSaveReq;
import com.choujiang.resp.PageResp;
import com.choujiang.resp.UserLoginResp;
import com.choujiang.resp.UserQueryResp;
import com.choujiang.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserService
 * @Description 用户的service
 * @createTime 2022/06/14 9:29
 **/
@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;
    @Resource
    private OrganizationMapper organizationMapper;
    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/14 9:40
      * @params: 
      * @return: 
      **/
    public void save(UserSaveReq req) {
        User user = CopyUtil.copy(req, User.class);
        // 添加操作
        if(ObjectUtils.isEmpty(req.getUserId())){
            User userdb = selectByUserName(req.getUserName());
            if(ObjectUtils.isEmpty(userdb)){
                // 新增
                userMapper.insert(user);
            }
        }else{
            // 更新
            user.setUserName(null);
            user.setUserPwd(null);
            userMapper.updateByPrimaryKeySelective(user);
        }

    }
    // 根据用户名查询用户
    public User selectByUserName(String username){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        } else {
            return users.get(0);
        }
    }

    public PageResp<UserQueryResp> list(UserQueryReq req) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        // 用户名称
        if(!ObjectUtils.isEmpty(req.getUserName())){
            criteria.andUserNameLike("%" + req.getUserName() + "%");
        }
        // 分页逻辑
        PageHelper.startPage(req.getPage(), req.getSize());
        List<User> userList = userMapper.selectByExample(userExample);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        // 列表复制
        List<UserQueryResp> list = new ArrayList<>();
        for (User user : userList) {
            UserQueryResp u = CopyUtil.copy(user, UserQueryResp.class);
            u.setOrganization(organizationMapper.selectByPrimaryKey(user.getOrgCode()));
            list.add(u);
        }
        // 返回结果
        PageResp<UserQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public UserLoginResp login(UserLoginReq req) {
        User userDb = selectByUserName(req.getUserName());
        if (ObjectUtils.isEmpty(userDb)) {
            // 用户名不存在
            LOG.info("用户名不存在, {}", req.getUserName());
            throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
        }else{
            if (userDb.getUserPwd().equals(req.getUserPwd())) {
                // 登录成功
                UserLoginResp userLoginResp = CopyUtil.copy(userDb, UserLoginResp.class);
                return userLoginResp;
            } else {
                // 密码不对
                LOG.info("密码不对, 输入密码：{}, 数据库密码：{}", req.getUserPwd(), userDb.getUserPwd());
                throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
            }
        }
    }

    public void resetPassword(UserResetPasswordReq req) {
        User user = CopyUtil.copy(req, User.class);
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
