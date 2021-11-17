package com.smile.auth.service;

import com.smile.auth.vo.SysUserVo;
import com.smile.common.core.domain.R;

/**
 * @author 张维麟
 * @date 2021/11/11 12:31
 */
public interface AuthRegisterService {
     /**
      * 注册
      * @param syUserVo 注册
      * @return  全局响应体
      */
     R doRegister(SysUserVo syUserVo);

}
