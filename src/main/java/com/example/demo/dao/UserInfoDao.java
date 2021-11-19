package com.example.demo.dao;

import com.example.demo.domain.model.UserInfo;
import com.example.demo.domain.request.userRequest.LoginRequest;
import com.example.demo.domain.request.userRequest.RegisterRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    Integer insertAndGetId(UserInfo userInfo);

    UserInfo selectByUserName(String userName);
}