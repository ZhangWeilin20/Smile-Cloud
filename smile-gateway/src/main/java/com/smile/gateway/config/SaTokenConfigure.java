package com.smile.gateway.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.smile.common.core.constant.ModuleConstant;
import com.smile.common.core.exception.BaseException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张维麟
 * @date 2021/11/10 16:42
 */
@Configuration
public class SaTokenConfigure {
    Log log = LogFactory.get();


    /**
     * 注册 [Sa-Token全局过滤器]
     */
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 指定 [拦截路由]
                .addInclude("/**")
                // 指定 [放行路由]
                .addExclude("/favicon.ico")
                // 指定[认证函数]: 每次请求执行
                .setAuth(obj -> log.info("(♥◠‿◠)ﾉﾞ  sa全局认证  ლ(´ڡ`ლ)ﾞ  \n"))
                // 指定[异常处理函数]：每次[认证函数]发生异常时执行此函数
                .setError(e -> {
                    log.info("(♥◠‿◠)ﾉﾞ  sa全局异常   ლ(´ڡ`ლ)ﾞ  \n",e);
                    return new BaseException(ModuleConstant.SMILE_GATEWAY, 10001, new String[]{e.getMessage()}, "sa全局异常");
                });
    }
}