package com.smile.common.core.exception;

import com.smile.common.core.domain.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 张维麟
 * @date 2021/11/2 12:53
 */
@ControllerAdvice
public class GlobalException {
    /**
     * Exception异常处理
     * @param e 异常
     * @return 异常信息
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R error(Exception e) {
        e.printStackTrace();
        return R.fail().message("执行Exception异常处理");
    }
    /**
     * 特定异常处理
     * @param e 异常
     * @return 异常信息
     */
    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.fail().message("执行ArithmeticException异常处理");
    }

    /**
     * 自定义异常处理
     * @param e 异常
     * @return 异常信息
     */
    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public R error(BaseException e){
        e.printStackTrace();
        return R.fail().code(e.getCODE()).message(e.getMESSAGE()).data("MODULE",e.getMODULE()).data("ARGS",e.getARGS());
    }
}
