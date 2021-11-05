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
public class Res {

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    /**
     * 构造方法私有化
     */
    private Res() {

    }

    public static Res success() {
        Res res = new Res();
        res.setSuccess(true);
        res.setCode(HttpStatus.HTTP_OK);
        res.setMessage("Success");
        return res;
    }

    public static Res fail() {
        Res res = new Res();
        res.setSuccess(false);
        res.setCode(HttpStatus.HTTP_BAD_REQUEST);
        res.setMessage("Fail");
        return res;
    }

    public Res success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
    public Res code(Integer code){
        this.setCode(code);
        return this;
    }
    public Res message(String message){
        this.setMessage(message);
        return this;
    }
    public Res data(String k, Object v){
        this.data.put(k, v);
        return this;
    }
    public Res data(Map<String, Object> map){
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
