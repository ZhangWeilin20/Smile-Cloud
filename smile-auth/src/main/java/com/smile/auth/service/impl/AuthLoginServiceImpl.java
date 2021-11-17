package com.smile.auth.service.impl;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.system.SystemUtil;
import com.smile.auth.feign.SysUserService;
import com.smile.auth.service.AuthLoginService;
import com.smile.auth.vo.SysUserVo;
import org.springframework.stereotype.Service;

/**
 * @author 张维麟
 * @date 2021/11/11 12:31
 */
@Service
public class AuthLoginServiceImpl implements AuthLoginService {
    final
    SysUserService sysUserService;
    public AuthLoginServiceImpl(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }


    @Override
    public SaTokenInfo doLogin(SysUserVo syUserVo) {
        sysUserService.doLogin(syUserVo);
        StpUtil.login(syUserVo.getAccount(), new SaLoginModel().setDevice(SystemUtil.getOsInfo().getName()));
        return StpUtil.getTokenInfo();
    }

}
