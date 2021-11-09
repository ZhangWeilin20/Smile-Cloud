package com.smile.gateway;

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
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@EnableDiscoveryClient
public class GateWayApplication {
    public static void main(String[] args) {
        Log log = LogFactory.get();
        SpringApplication.run(GateWayApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  网关模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}