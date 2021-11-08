package com.smile.member.controller;


import com.smile.common.core.domain.Res;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-08 16:05:24
 */
@RestController
@RequestMapping("/member/ums-member-entity")
public class UmsMemberController {

    @PostMapping("/insertOne")
    public Res insertOne(){


        return Res.success();
    }



}

