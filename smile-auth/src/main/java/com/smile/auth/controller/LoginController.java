package com.smile.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.smile.auth.service.AuthLoginService;
import com.smile.auth.vo.UmsMemberVo;
import com.smile.common.core.domain.Res;
import org.springframework.web.bind.annotation.*;

/**
 * @author 张维麟
 * @date 2021/11/10 15:29
 */
@RestController
@RequestMapping("/auth")
public class LoginController {
    final
    AuthLoginService authLoginService;

    public LoginController(AuthLoginService authLoginService) {
        this.authLoginService = authLoginService;
    }
    /**
     * 登录
     * @param umsMemberVo 登录对象
     * @return 响应
     */
    @PostMapping("/login")
    public Res doLogin(@RequestBody UmsMemberVo umsMemberVo) {
        return authLoginService.doLogin(umsMemberVo);
    }
    /**
     *  查询登录状态
     */

    @GetMapping("isLogin")
    public Res isLogin() {
        return Res.success().data("是否登录" , StpUtil.isLogin());
    }
    /**
     *   测试注销
     */

    @GetMapping("logout")
    public Res logout() {
        StpUtil.logout();
        return Res.success();
    }

}
