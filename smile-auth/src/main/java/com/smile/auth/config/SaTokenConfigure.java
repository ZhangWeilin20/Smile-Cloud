package com.smile.auth.config;

import cn.dev33.satoken.jwt.StpLogicJwtForStyle;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张维麟
 * @date 2021/11/10 14:08
 */
@Configuration
public class SaTokenConfigure {
    /**
     *  Sa-Token 整合 jwt (Style模式)
     * @return Token
     */
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForStyle();
    }
}