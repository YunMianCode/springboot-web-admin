package com.springboot.admin.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 配置Swagger的Docket的 bean实例
     *
     * @param environment 环境生产模式
     * @return docket
     */
    @Bean
    public Docket docket(Environment environment) {
        //设置要显示的Swagger环境
        // Profiles profiles = Profiles.of("dev", "test");
        //如何获得当前的生产模式？通environment.acceptsProfiles 判断是否处在自己设定的环境中
        // boolean flag = environment.acceptsProfiles(profiles);
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("云棉")
                //enable是否启动swagger，如果为false，则swagger不能在浏览器中访问
                // .enable(flag)
                .select()
                //RequestHandlerSelectors, 配置要扫描接口的方式；basePackage指定包
                .apis(RequestHandlerSelectors.basePackage("com.springboot.admin"))
                .build();
        return docket;
    }

    /**
     * 配置Swagger 信息= apiInfo
     *
     * @return 返回作者信息
     */
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("郭安", "http://localhost:8088", "1813850191@qq.com");
        return new ApiInfo("云棉的API文档 ",
                "接口文档",
                "1.0.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
