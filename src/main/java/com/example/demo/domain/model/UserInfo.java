package com.example.demo.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_info
 * @author 
 */
@ApiModel(value="com.example.demo.entity.UserInfo用户登录注册信息")
@Data
public class UserInfo implements Serializable {
    /**
     * 唯一标识主键
     */
    @ApiModelProperty(value="唯一标识主键")
    private Integer id;

    /**
     * 用户唯一标识id
     */
    @ApiModelProperty(value="用户唯一标识id")
    private Integer userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String userName;

    /**
     * 用户密码
     */
    @ApiModelProperty(value="用户密码")
    private String userPassword;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value="用户昵称")
    private String userNickname;

    /**
     * 注册手机号
     */
    @ApiModelProperty(value="注册手机号")
    private Integer userPhoneNumber;

    /**
     * 邮箱地址
     */
    @ApiModelProperty(value="邮箱地址")
    private String userEmail;

    /**
     * 用户创建时间
     */
    @ApiModelProperty(value="用户创建时间")
    private Date craeteDate;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}