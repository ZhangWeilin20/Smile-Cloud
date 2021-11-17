package com.smile.system.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 张维麟
 * @date 2021/11/8 13:03
 */
public class GenerateCode {

    /**
     * 数据源配置
     */

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/smile_ums";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "000000";
    private static final String DIR = "C://Users//smile//Desktop";
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(URL, USERNAME, PASSWORD);

    public static void main(String[] args) {

        FastAutoGenerator.create(DATA_SOURCE_CONFIG)

                // 全局配置
                .globalConfig(
                        (scanner, builder) ->
                                builder.author(scanner.apply("请输入作者名称？"))
                                        .enableSwagger() //开启Swagger
                                        .fileOverride()  //覆盖
                                        .dateType(DateType.TIME_PACK)
                                        .commentDate("yyyy-MM-dd HH:mm:ss")
                                        .outputDir(DIR)
                )
                // 包配置
                .packageConfig(
                        (scanner, builder) ->
                                builder.parent(scanner.apply("请输入包名？"))
                                        .moduleName(scanner.apply("请输入模块名？"))
                                        .entity("entity")
                                        .service("service")
                                        .serviceImpl("service.impl")
                                        .mapper("mapper")
                                        .xml("mapper.xml")
                                        .controller("controller")

                )
                // 策略配置
                .strategyConfig(
                        (scanner, builder) ->
                                builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                                        .controllerBuilder()
                                        //.superClass(BaseController.class)
                                        .enableHyphenStyle()
                                        .enableRestStyle()
                                        .formatFileName("%sController")

                                        .serviceBuilder()
                                        //.superServiceClass(BaseService.class)
                                        //.superServiceImplClass(BaseServiceImpl.class)
                                        .formatServiceFileName("%sService")
                                        .formatServiceImplFileName("%sServiceImp")


                                        .mapperBuilder()
                                        //.superClass(BaseMapper.class)
                                        .enableMapperAnnotation()
                                        .enableBaseResultMap()
                                        .enableBaseColumnList()
                                        //.cache(MyMapperCache.class)
                                        .formatMapperFileName("%sDao")
                                        .formatXmlFileName("%sXml")


                                        .entityBuilder()
                                        //.superClass(BaseEntity.class)
                                        //.disableSerialVersionUID()
                                        .enableColumnConstant() //开启生成字段常量
                                        .enableChainModel() //开启链式模型
                                        .enableLombok()  //开启 lombok 模型
                                        .enableRemoveIsPrefix() //开启 Boolean 类型字段移除 is 前缀
                                        .enableTableFieldAnnotation() //开启生成实体时生成字段注解
                                        .enableActiveRecord() //开启 ActiveRecord 模型
                                        .versionColumnName("version") //乐观锁字段名(数据库)
                                        .versionPropertyName("version") //乐观锁属性名(实体)
                                        .logicDeleteColumnName("del_flag") //逻辑删除字段名(数据库)
                                        .logicDeletePropertyName("del_flag") //逻辑删除属性名(实体)
                                        //.naming(NamingStrategy.no_change) //数据库表映射到实体的命名策略
                                        //.columnNaming(NamingStrategy.underline_to_camel) //数据库表字段映射到实体的命名策略
                                        .addSuperEntityColumns( "created_time", "updated_time")
                                        //.addIgnoreColumns("age")
                                        .addTableFills(new Column("create_time", FieldFill.INSERT),new Column("update_time", FieldFill.INSERT_UPDATE))
                                        //.addTableFills(new Property("update_time", FieldFill.INSERT_UPDATE))
                                        .idType(IdType.AUTO)
                                        .formatFileName("%sEntity")



                                        .build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .execute();
    }

    /**
     * 处理多表
     *
     * @param tables 表名
     * @return 表
     */
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
