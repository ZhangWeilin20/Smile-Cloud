package com.smile.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.smile.auth.feign.UmsMemberService;
import com.smile.auth.vo.UmsMemberVo;
import com.smile.common.core.domain.Res;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张维麟
 * @date 2021/11/10 15:29
 */
@RestController
@RequestMapping("/auth")
public class LoginController {
    final
    UmsMemberService umsMemberService;

    public LoginController(UmsMemberService umsMemberService) {
        this.umsMemberService = umsMemberService;
    }

    @PostMapping("/login")
    public Res selectOne(@RequestBody UmsMemberVo umsMemberVo) {
        umsMemberService.selectOne(umsMemberVo);
        StpUtil.login(10001);
        return Res.success().code(200).message("登录成功");
    }

}
