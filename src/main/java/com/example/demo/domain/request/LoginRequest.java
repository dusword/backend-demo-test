package com.example.demo.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * @author :LiXiangJie
 * @description : TODO
 * @date :2021/11/19 21:17
 */
@ApiModel(value="用户登录请求")
@Data
public class LoginRequest {
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
}
