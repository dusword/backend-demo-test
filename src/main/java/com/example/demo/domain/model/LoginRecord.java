package com.example.demo.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * login_record
 * @author 
 */
@ApiModel(value="com.example.demo.entity.LoginRecord用户登录记录表")
@Data
public class LoginRecord implements Serializable {
    /**
     * 唯一标识主键
     */
    @ApiModelProperty(value="唯一标识主键")
    private Integer id;

    /**
     * 登录用户id
     */
    @ApiModelProperty(value="登录用户id")
    private Integer userId;

    /**
     * 登陆时间
     */
    @ApiModelProperty(value="登陆时间")
    private Date loginTime;

    /**
     * 登录ip
     */
    @ApiModelProperty(value="登录ip")
    private String ipAddress;

    private static final long serialVersionUID = 1L;
}