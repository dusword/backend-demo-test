package com.example.demo.domain.request;

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
    @ApiModelProperty(value="用户名",example = "lixiangjie")
    private String userName;

    /**
     * 用户密码
     */
    @ApiModelProperty(value="用户密码",example = "123456")
    private String userPassword;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value="用户昵称",example = "dusword")
    private String userNickname;

    /**
     * 注册手机号
     */
    @ApiModelProperty(value="注册手机号",example = "13761717870")
    private String userPhoneNumber;

    /**
     * 邮箱地址
     */
    @ApiModelProperty(value="邮箱地址",example = "773983534@qq.com")
    private String userEmail;
}
