package com.smile.member.controller;


import com.smile.common.core.domain.R;
import com.smile.member.entity.SysUserEntity;
import com.smile.member.service.SysUserService;
import com.smile.member.vo.SysUserVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-17 10:16:20
 */
@RestController
public class SysUserController {
    final
    SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 添加一个
     * @param syUserVo 注册信息对象
     * @return 是否成功
     */
    @PostMapping("/insertOne")
    public R doRegister(@RequestBody SysUserVo syUserVo){

        sysUserService.doRegister(syUserVo);

        return R.success().code(200).message("插入成功");
    }

    /**
     * 登录查询
     * @param syUserVo 登录信息对象
     * @return 是否成功
     */
    @PostMapping("/selectOne")
    public R doLogin(@RequestBody SysUserVo syUserVo) {
        SysUserEntity sysUserEntity =  sysUserService.doLogin(syUserVo);
        return R.success().code(200).message("查询成功").data("entity",sysUserEntity);
    }
}

