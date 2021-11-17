package com.smile.auth.controller;

import com.smile.auth.service.AuthRegisterService;
import com.smile.auth.vo.SysUserVo;
import com.smile.common.core.domain.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张维麟
 * @date 2021/11/10 10:12
 */
@RestController
public class RegisterController {
    final
    AuthRegisterService authRegisterService;

    public RegisterController(AuthRegisterService authRegisterService) {
        this.authRegisterService = authRegisterService;
    }

    /**
     * 注册
     * @param syUserVo 注册对象
     * @return 响应
     */
    @PostMapping("/register")
    public R doRegister(@RequestBody SysUserVo syUserVo){
        return authRegisterService.doRegister(syUserVo);
    }
}
