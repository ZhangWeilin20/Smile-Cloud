package com.smile.member;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author 张维麟
 * @date 2021/11/2 14:26
 */

@SpringBootApplication(scanBasePackages = "com.smile.**")
@EnableDiscoveryClient
@EnableFeignClients
@RefreshScope
public class MemberApplication {
    public static void main(String[] args) {
        Log log = LogFactory.get();
        SpringApplication.run(MemberApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  人员模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}