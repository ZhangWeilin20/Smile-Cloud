package com.smile.common.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author 张维麟
 * @date 2021/11/2 12:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
    private  final String MODULE = null;

    /**
     * 错误码
     */
    private  final Integer CODE = null;

    /**
     * 错误码对应的参数
     */
    private  final Object[] ARGS = new Object[0];

    /**
     * 错误消息
     */
    private  final String DEFAULT_MESSAGE = null;

}
