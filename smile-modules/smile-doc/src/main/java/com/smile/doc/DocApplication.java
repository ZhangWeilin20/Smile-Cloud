package com.smile.doc;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 张维麟
 * @date 2021/11/2 14:26
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class},scanBasePackages = "com.smile.**")
public class DocApplication {
    public static void main(String[] args) {
        Log log = LogFactory.get();
        SpringApplication.run(DocApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  文档模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}