package com.springboot.admin.xxs.RequestBodyXXS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigOfXXS implements WebMvcConfigurer, InitializingBean {

    /**
     * 默认就是@Autowired(required=true)，表示注入的时候，该bean必须存在，否则就会注入失败required = false,表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错
     */
    @Autowired(required = false)
    private ObjectMapper objectMapper;

    private SimpleModule getSimpleModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(String.class, new JsonHtmlXssDeserializer(String.class));
        return simpleModule;
    }

    /**
     * 初始化bean的时候执行，可以针对某个具体的bean进行配置。afterPropertiesSet 必须实现 InitializingBean接口。实现 InitializingBean接口必须实现afterPropertiesSet方法
     * 这个方法将在所有的属性被初始化后调用,但是会在init前调用
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if (objectMapper != null) {
            SimpleModule simpleModule = getSimpleModule();
            objectMapper.registerModule(simpleModule);
        }
    }
}
