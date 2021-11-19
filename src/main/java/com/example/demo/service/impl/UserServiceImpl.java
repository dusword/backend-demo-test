package com.example.demo.service.impl;

import com.example.demo.dao.LoginRecordDao;
import com.example.demo.dao.UserInfoDao;
import com.example.demo.domain.model.UserInfo;
import com.example.demo.domain.request.userRequest.LoginRequest;
import com.example.demo.domain.request.userRequest.RegisterRequest;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :LiXiangJie
 * @description : TODO
 * @date :2021/11/19 21:28
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Resource
    UserInfoDao userInfoDao;

    @Override
    public UserInfo userRegister(RegisterRequest registerRequest) {
        UserInfo userInfo = userInfoDao.selectByUserName(registerRequest.getUserName());
        if (!userInfo.getUserName().equals(registerRequest.getUserName())) {
            BeanUtils.copyProperties(registerRequest, userInfo);
            Integer id = userInfoDao.insertAndGetId(userInfo);
            if (id != null) {
                log.info("用户： "+id+" 注册成功");
                return userInfoDao.selectByPrimaryKey(id);
            }
            log.error("注册失败");
            return new UserInfo();
        }
        log.error("用户名重复");
        return new UserInfo();
    }

    @Override
    public UserInfo userLogin(LoginRequest loginRequest) {
        log.info("开始登录");
        UserInfo userInfo = userInfoDao.selectByUserName(loginRequest.getUserName());
        if (userInfo != null) {
            if (loginRequest.getUserPassword().equals(userInfo.getUserPassword())) {
                log.info("用户id： "+userInfo.getId()+" 登陆成功");
                return userInfo;
            }
            log.error("密码错误");
            return new UserInfo();
        }
        log.error("用户不存在");
        return new UserInfo();
    }
}