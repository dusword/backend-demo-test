package com.example.demo.service.impl;

import com.example.demo.dao.UserInfoDao;
import com.example.demo.domain.model.UserInfo;
import com.example.demo.domain.request.LoginRequest;
import com.example.demo.domain.request.RegisterRequest;
import com.example.demo.result.BaseResult;
import com.example.demo.service.UserService;
import com.example.demo.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
    public BaseResult userRegister(RegisterRequest registerRequest) {
        UserInfo userInfo = new UserInfo();
        if (userInfoDao.selectByUserName(registerRequest.getUserName()) == null) {
            BeanUtils.copyProperties(registerRequest, userInfo);
            userInfo.setCraeteDate(new Date());
            userInfoDao.insertAndGetId(userInfo);
            Integer id =userInfo.getId();
            if (id != null) {
                log.info("用户： " + id + " 注册成功");
                return BaseResult.ok().data("userInfo",userInfoDao.selectByPrimaryKey(id));
            }
            log.error("注册失败");
            return BaseResult.error().message("注册失败");
        }
        log.error("用户名重复");
        return BaseResult.error().message("用户名重复");
    }

    @Override
    public BaseResult userLogin(LoginRequest loginRequest, HttpServletRequest httpServletRequest) {
        log.info("开始登录");
        UserInfo userInfo = userInfoDao.selectByUserName(loginRequest.getUserName());
        if (userInfo != null) {
            if (loginRequest.getUserPassword().equals(userInfo.getUserPassword())) {
                log.info("用户id： " + userInfo.getId() + " 登陆成功,登录ip: "+ IpUtil.getIpAddr(httpServletRequest));
                httpServletRequest.getSession().setAttribute("userInfoId",userInfo.getId());
                return BaseResult.ok().message("登陆成功").data("userInfo",userInfo);
            }
            log.error("密码错误");
            return BaseResult.error().message("密码错误");
        }
        log.error("用户不存在");
        return BaseResult.error().message("用户不存在");
    }
}