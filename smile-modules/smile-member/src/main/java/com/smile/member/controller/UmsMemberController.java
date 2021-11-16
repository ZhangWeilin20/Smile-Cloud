package com.smile.member.controller;


import com.smile.common.core.domain.Res;
import com.smile.member.entity.UmsMemberEntity;
import com.smile.member.service.UmsMemberService;
import com.smile.member.vo.UmsMemberVo;
import io.swagger.annotations.ApiModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@ApiModel(value = "UmsMemberEntity对象", description = "用户信息表")
public class UmsMemberController {

    final
    UmsMemberService umsMemberService;

    public UmsMemberController(UmsMemberService umsMemberService) {
        this.umsMemberService = umsMemberService;
    }

    /**
     * 添加一个
     * @param umsMemberVo 注册信息对象
     * @return 是否成功
     */
    @PostMapping("/insertOne")
    public Res doRegister(@RequestBody UmsMemberVo umsMemberVo){

        umsMemberService.doRegister(umsMemberVo);

        return Res.success().code(200).message("插入成功");
    }

    /**
     * 登录查询
     * @param umsMemberVo 登录信息对象
     * @return 是否成功
     */
    @PostMapping("/selectOne")
    public Res doLogin(@RequestBody UmsMemberVo umsMemberVo) {
        UmsMemberEntity umsMemberEntity =  umsMemberService.doLogin(umsMemberVo);
        return Res.success().code(200).message("查询成功").data("entity",umsMemberEntity);
    }

}

