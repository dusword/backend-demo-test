package com.example.demo.service;

import com.example.demo.domain.request.LoginRequest;
import com.example.demo.domain.request.RegisterRequest;
import com.example.demo.result.BaseResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Service
public interface UserService {
    BaseResult userRegister(RegisterRequest registerRequest);

    BaseResult userLogin(LoginRequest loginRequest, HttpServletRequest httpServletRequest);
}
