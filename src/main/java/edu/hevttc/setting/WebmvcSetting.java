package edu.hevttc.setting;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author Pc.dragon
 * @ClassName WebmvcSetting
 * @description: 设置全局跨域
 * @date 2023年01月16日
 * @version: 1.0
 */
@Configuration
@Slf4j
public class WebmvcSetting implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("===========addCorsMappings===========");
        registry.addMapping("/**")  //拦截的请求地址，支持跨域
                .allowedOriginPatterns("*")      //可跨域的域名,请求的来源
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS") //允许跨域的请求方式
                .allowCredentials(true)          //服务器支持cookie
                .maxAge(3600)                    //预检请求的有效期，3600秒
                .allowedHeaders("*");            //在请求header中可包含哪些内容
    }

}
