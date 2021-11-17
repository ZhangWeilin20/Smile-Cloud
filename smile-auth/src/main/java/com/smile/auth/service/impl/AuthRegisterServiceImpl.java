package com.smile.auth.service.impl;

import com.smile.auth.feign.SysUserService;
import com.smile.auth.service.AuthRegisterService;
import com.smile.auth.vo.SysUserVo;
import com.smile.common.core.domain.R;
import org.springframework.stereotype.Service;

/**
 * @author 张维麟
 * @date 2021/11/11 12:31
 */
@Service
public class AuthRegisterServiceImpl implements AuthRegisterService {
    final
    SysUserService sysUserService;
    public AuthRegisterServiceImpl(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @Override
    public R doRegister(SysUserVo syUserVo) {
        return sysUserService.doRegister(syUserVo);
    }
}
