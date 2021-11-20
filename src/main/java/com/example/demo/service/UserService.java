package com.example.demo.service;

import com.example.demo.domain.model.UserInfo;
import com.example.demo.domain.request.userRequest.LoginRequest;
import com.example.demo.domain.request.userRequest.RegisterRequest;
import com.example.demo.result.BaseResult;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public interface UserService {
    BaseResult userRegister(RegisterRequest registerRequest);

    BaseResult userLogin(LoginRequest loginRequest, HttpServletRequest httpServletRequest);
}
