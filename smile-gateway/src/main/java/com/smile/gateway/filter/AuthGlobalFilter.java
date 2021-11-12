package com.smile.gateway.filter;


import com.alibaba.nacos.shaded.com.google.gson.JsonObject;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;


/**
 * @author 张维麟
 * @date 2021/11/12 9:00
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {
  private final AntPathMatcher antPathMatcher =   new AntPathMatcher();
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
//        if (antPathMatcher.match("/**/auth/**", path)){
//            List<HttpCookie> tokenList = request.getCookies().get("token");
//            System.out.println("tokenList = " + tokenList);
//            if (tokenList != null && !tokenList.isEmpty()) {
//                return chain.filter(exchange);
//            }else {
//                ServerHttpResponse response = exchange.getResponse();
//                return out(response);
//            }
//
//       }
//        if (antPathMatcher.match("/**/inner/**", path)){
//            ServerHttpResponse response = exchange.getResponse();
//            return out(response);
//        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
    /**
     *     自定义 ExtensionErrorAttributes Bean注册
     */
    private Mono<Void> out(ServerHttpResponse response) {
        JsonObject message = new JsonObject();
        message.addProperty("success", false);
        message.addProperty("code", 28004);
        message.addProperty("data", "鉴权失败");
        byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        //指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
