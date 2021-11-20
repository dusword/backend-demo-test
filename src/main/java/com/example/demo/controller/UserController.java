package com.example.demo.controller;

import com.example.demo.domain.request.LoginRequest;
import com.example.demo.domain.request.RegisterRequest;
import com.example.demo.result.BaseResult;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
@Api("User相关的api")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value="注册接口", notes="发送注册请求", produces="application/json")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    BaseResult userRegister(@RequestBody RegisterRequest registerRequest){
        return userService.userRegister(registerRequest);
    }

    @ApiOperation(value="登录接口", notes="发送登录请求", produces="application/json")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    BaseResult userLogin(@RequestBody LoginRequest LoginRequest, HttpServletRequest httpServletRequest){
        return userService.userLogin(LoginRequest,httpServletRequest);
    }

}
