package com.smile.auth.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.smile.auth.vo.SysUserVo;

/**
 * @author 张维麟
 * @date 2021/11/11 12:31
 */
public interface AuthLoginService {
     /**
      * 登录
      * @param syUserVo 登录
      */
     SaTokenInfo doLogin(SysUserVo syUserVo) ;

}
