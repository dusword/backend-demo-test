package com.example.demo.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :LiXiangJie
 * @description : TODO
 * @date :2021/11/19 21:03
 */
@Data
public class BaseResult {

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String,Object>data=new HashMap<String, Object>();

    private BaseResult(){}

    public static BaseResult ok(){
        BaseResult baseResult=new BaseResult();
        baseResult.setSuccess(true);
        baseResult.setCode(ReturnCode.SUCCESS);
        baseResult.setMessage("成功");
        return baseResult;
    }

    public static BaseResult error(){
        BaseResult r = new BaseResult();
        r.setSuccess(false);
        r.setCode(ReturnCode.FAILURE);
        r.setMessage("失败");
        return r;
    }

    public BaseResult success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public BaseResult message(String message){
        this.setMessage(message);
        return this;
    }

    public BaseResult code(Integer code){
        this.setCode(code);
        return this;
    }

    public BaseResult data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public BaseResult data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
