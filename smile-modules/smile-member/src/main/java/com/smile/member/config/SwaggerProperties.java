package com.smile.member.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 张维麟
 * @date 2021/11/2 13:22
 */
@ConfigurationProperties(prefix = "springfox.swagger")
@Data
public class SwaggerProperties {
    /**
     * 前台接口配置
     */
    private SwaggerEntity front;
    /**
     * 后台接口配置
     */
    private SwaggerEntity back;
    @Data
    public static class SwaggerEntity {
        private String groupName;
        private String basePackage;
        private String title;
        private String description;
        private String contactName;
        private String contactEmail;
        private String contactUrl;
        private String version;
        private Boolean enable;
    }
}
