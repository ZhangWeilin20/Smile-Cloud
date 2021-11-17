package com.smile.auth.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.smile.auth.service.AuthLoginService;
import com.smile.auth.vo.SysUserVo;
import com.smile.common.core.domain.R;
import io.swagger.annotations.ApiModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张维麟
 * @date 2021/11/10 15:29
 */
@RestController
@ApiModel(value = "对象", description = "登录")
public class LoginController {
    final
    AuthLoginService authLoginService;

    public LoginController(AuthLoginService authLoginService) {
        this.authLoginService = authLoginService;
    }
    /**
     * 登录
     * @param syUserVo 登录对象
     * @return 响应
     */
    @PostMapping("/login")
    public R doLogin(@RequestBody SysUserVo syUserVo) {
        SaTokenInfo saTokenInfo = authLoginService.doLogin(syUserVo);

        return R.success().message("登录成功").data("tokenInfo",saTokenInfo);
    }
    /**
     *  查询登录状态
     */

    @GetMapping("isLogin")
    public R isLogin() {
        return R.success().data("是否登录" , StpUtil.isLogin());
    }
    @GetMapping("tokenInfo")
    public R tokenInfo(){return R.success().data("tokenInfo",StpUtil.getTokenInfo());}
    /**
     *   测试注销
     */

    @GetMapping("logout")
    public R logout() {
        StpUtil.logout();
        return R.success();
    }


}
