package com.smile.auth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.smile.auth.feign.UmsMemberService;
import com.smile.auth.service.AuthLoginService;
import com.smile.auth.vo.UmsMemberVo;
import com.smile.common.core.domain.Res;
import org.springframework.stereotype.Service;

/**
 * @author 张维麟
 * @date 2021/11/11 12:31
 */
@Service
public class AuthLoginServiceImpl implements AuthLoginService {
    final
    UmsMemberService umsMemberService;
    public AuthLoginServiceImpl(UmsMemberService umsMemberService) {
        this.umsMemberService = umsMemberService;
    }


    @Override
    public Res doLogin(UmsMemberVo umsMemberVo) {
        Res res = umsMemberService.doLogin(umsMemberVo);
        StpUtil.login(umsMemberVo.getUserName());
        return res;
    }

}
