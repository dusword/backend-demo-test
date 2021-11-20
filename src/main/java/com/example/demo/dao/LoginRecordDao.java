package com.example.demo.dao;

import com.example.demo.domain.model.LoginRecord;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginRecord record);

    int insertSelective(LoginRecord record);

    LoginRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginRecord record);

    int updateByPrimaryKey(LoginRecord record);


}