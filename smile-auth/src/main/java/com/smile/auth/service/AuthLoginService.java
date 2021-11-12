package com.smile.auth.service;

import com.smile.auth.vo.UmsMemberVo;
import com.smile.common.core.domain.Res;

/**
 * @author 张维麟
 * @date 2021/11/11 12:31
 */
public interface AuthLoginService {
     /**
      * 登录
      * @param umsMemberVo 登录
      * @return  全局响应体
      */
     Res doLogin(UmsMemberVo umsMemberVo) ;

}
