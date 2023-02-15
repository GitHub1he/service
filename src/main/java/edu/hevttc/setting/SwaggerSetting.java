package edu.hevttc.setting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Pc.dragon
 * @ClassName SwaggerSetting
 * @description: swagger
 * @date 2023年01月15日
 * @version: 1.0
 */
@Configuration
public class SwaggerSetting {
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfoBuilder().title("高校学生学业动态监控系统")//接口文档标题
                .version("1.0")//接口文档版本
                .description("管理系统，使用的技术栈:<br/>1.前端：javascript,css,html.<br?>" +
                        "2.后端:spring boot ,mybatis-plus , redis ,mysql")//接口文档藐视
                .contact(new Contact("潘晨龙", "无", "pclwhy419@163.com"))//联系人
                .license("Apache2.0")//许可生命
                .build();//构建
        docket = docket.apiInfo(apiInfo);
        docket = docket.select().apis(RequestHandlerSelectors.basePackage("edu.hevttc")).build();
        docket.enable(true);
        return docket;
    }
}
