package com.example.demo.domain.request.userRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :LiXiangJie
 * @description : TODO
 * @date :2021/11/19 21:15
 */
@ApiModel(value="用户注册请求")
@Data
public class RegisterRequest {
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
}
