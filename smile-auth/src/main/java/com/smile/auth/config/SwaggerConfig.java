package com.smile.auth.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.models.auth.In;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * @author 张维麟
 * @date 2021/11/2 13:15
 */
@EnableKnife4j
@EnableOpenApi
@Configuration
@Profile({"dev","test"})
@EnableConfigurationProperties(value = {SwaggerProperties.class})
public class SwaggerConfig {
    /**
     * 配置属性
     */
    private final SwaggerProperties properties;

    public SwaggerConfig(SwaggerProperties properties) {
        this.properties = properties;
    }
    @Bean
    public Docket frontApi() {
        RequestParameter parameter = new RequestParameterBuilder()
                .name("platform")
                .description("请求头")
                .in(ParameterType.HEADER)
                .required(true)
                .build();
        List<RequestParameter> parameters = Collections.singletonList(parameter);
        return new Docket(DocumentationType.OAS_30)
                //是否开启，根据环境配置
                .enable(properties.getFront().getEnable())
                .groupName(properties.getFront().getGroupName())
                .apiInfo(frontApiInfo())
                .select()
                //指定扫描的包
                .apis(RequestHandlerSelectors.basePackage(properties.getFront().getBasePackage()))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(parameters)
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }
    /**
     * 前台API信息
     */
    private ApiInfo frontApiInfo() {
        return new ApiInfoBuilder()
                .title(properties.getFront().getTitle())
                .description(properties.getFront().getDescription())
                .version(properties.getFront().getVersion())
                .contact(    //添加开发者的一些信息
                        new Contact(properties.getFront().getContactName(), properties.getFront().getContactUrl(),
                                properties.getFront().getContactEmail()))
                .build();
    }

    /**
     * 后台API
     */
    @Bean
    public Docket backApi() {
        return new Docket(DocumentationType.OAS_30)
                //是否开启，根据环境配置
                .enable(properties.getBack().getEnable())
                .groupName(properties.getBack().getGroupName())
                .apiInfo(backApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getBack().getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 后台API信息
     */
    private ApiInfo backApiInfo() {
        return new ApiInfoBuilder()
                .title(properties.getBack().getTitle())
                .description(properties.getBack().getDescription())
                .version(properties.getBack().getVersion())
                .contact(    //添加开发者的一些信息
                        new Contact(properties.getBack().getContactName(), properties.getBack().getContactUrl(),
                                properties.getBack().getContactEmail()))
                .build();
    }
    /**
     * 设置授权信息
     */
    private List<SecurityScheme> securitySchemes() {
        var apiKey = new ApiKey("BASE_TOKEN", "token", In.HEADER.toValue());
        return Collections.singletonList(apiKey);
    }
    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(Collections.singletonList(new SecurityReference("BASE_TOKEN", new AuthorizationScope[]{new AuthorizationScope("global", "")})))
                        .build()
        );
    }
}
