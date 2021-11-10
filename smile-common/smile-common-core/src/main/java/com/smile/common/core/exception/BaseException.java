package com.smile.common.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * @author 张维麟
 * @date 2021/11/2 12:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
    private   String MODULE = null;

    /**
     * 错误码
     */
    private   Integer CODE = null;

    /**
     * 错误码对应的参数
     */
    private   Object[] ARGS = new Object[0];

    /**
     * 错误消息
     */
    private   String MESSAGE = null;

}
