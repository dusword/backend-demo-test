package com.example.demo.service;

import com.example.demo.domain.model.UserInfo;
import com.example.demo.domain.request.userRequest.LoginRequest;
import com.example.demo.domain.request.userRequest.RegisterRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    UserInfo userRegister(RegisterRequest registerRequest);

    UserInfo userLogin(LoginRequest loginRequest);
}
