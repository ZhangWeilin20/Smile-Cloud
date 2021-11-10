package com.smile.auth.controller;

import com.smile.auth.feign.UmsMemberService;
import com.smile.auth.vo.UmsMemberVo;
import com.smile.common.core.domain.Res;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张维麟
 * @date 2021/11/10 10:12
 */
@RestController
@RequestMapping("/auth")
public class RegisterController {
    final
    UmsMemberService umsMemberService;

    public RegisterController(UmsMemberService umsMemberService) {
        this.umsMemberService = umsMemberService;
    }

    @PostMapping("/register")
    public Res register(@RequestBody UmsMemberVo umsMemberVo){
        umsMemberService.insertOne(umsMemberVo);
        return Res.success().code(200).message("注册成功");
    }

}
