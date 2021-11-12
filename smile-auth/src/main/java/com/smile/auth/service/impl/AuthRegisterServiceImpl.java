package com.smile.auth.service.impl;

import com.smile.auth.feign.UmsMemberService;
import com.smile.auth.service.AuthRegisterService;
import com.smile.auth.vo.UmsMemberVo;
import com.smile.common.core.domain.Res;
import org.springframework.stereotype.Service;

/**
 * @author 张维麟
 * @date 2021/11/11 12:31
 */
@Service
public class AuthRegisterServiceImpl implements AuthRegisterService {
    final
    UmsMemberService umsMemberService;
    public AuthRegisterServiceImpl(UmsMemberService umsMemberService) {
        this.umsMemberService = umsMemberService;
    }

    @Override
    public Res doRegister(UmsMemberVo umsMemberVo) {
        return umsMemberService.doRegister(umsMemberVo);
    }
}
