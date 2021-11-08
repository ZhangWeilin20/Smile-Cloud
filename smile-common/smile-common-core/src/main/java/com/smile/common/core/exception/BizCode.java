package com.smile.common.core.exception;


/**
 * @author 张维麟
 * @date 2021/11/8 10:50
 */

public enum BizCode {
    /**
     *
     */
    SUCCE_CODE(20000,"成功"),
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VAILD_EXCEPTION(10001,"参数格式校验失败");


    private Integer code;
    private String message;

    BizCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
