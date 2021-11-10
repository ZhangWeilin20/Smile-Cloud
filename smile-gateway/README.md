# Smile-Gateway

## 1: 引入依赖

        <!-- SpringCloud Alibaba Nacos -->
        <dependency>
            <groupId>com.alibaba.nacos</groupId>
            <artifactId>nacos-client</artifactId>
        </dependency>
        <!-- SpringCloud Alibaba Nacos -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <!-- SpringCloud Alibaba Nacos Config -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
        <!-- SpringCloud GateWay -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>
         <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-loadbalancer</artifactId>
        </dependency>
## 2：主启动类添加注解，排除自动注入类

        @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
        @EnableDiscoveryClient
## 3：配置yml
    
### 注意
####1: 启动类必须排除数据库自动导入依赖
####2: pom依赖不能引入 spring-boot-starter-web 依赖
####3: 若需要使用负载均衡必须引入 spring-cloud-loadbalancer 依赖，并且服务发现必须配置在一个group中