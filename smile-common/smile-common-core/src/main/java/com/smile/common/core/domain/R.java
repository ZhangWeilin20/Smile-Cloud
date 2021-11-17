package com.smile.common.core.domain;

import cn.hutool.http.HttpStatus;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张维麟
 * @date 2021/11/2 12:24
 */
@Data
public class R {

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    /**
     * 构造方法私有化
     */
    private R() {

    }

    public static R success() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(HttpStatus.HTTP_OK);
        r.setMessage("Success");
        return r;
    }

    public static R fail() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(HttpStatus.HTTP_BAD_REQUEST);
        r.setMessage("Fail");
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
    public R code(Integer code){
        this.setCode(code);
        return this;
    }
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R data(String k, Object v){
        this.data.put(k, v);
        return this;
    }
    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
