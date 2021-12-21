//package com.springboot.admin.xxs.RequestBodyXXS;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ListIterator;
//
//@Configuration
//public class WebMvcConfig  extends WebMvcConfigurationSupport {
//
//    @Override
//    protected void extendMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
//        /**
//         * 替换默认的MappingJackson2HttpMessageConverter，过滤(json请求参数)xss
//         */
//        ListIterator<HttpMessageConverter<?>> listIterator = messageConverters.listIterator();
//        while (listIterator.hasNext()) {
//            HttpMessageConverter<?> next = listIterator.next();
//            if (next instanceof MappingJackson2HttpMessageConverter) {
//                listIterator.remove();
//                break;
//            }
//        }
//        messageConverters.add(getMappingJackson2HttpMessageConverter());
//
//    }
//
//    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
//        // 创建自定义ObjectMapper
//        SimpleModule module = new SimpleModule();
//        module.addDeserializer(String.class, new JsonHtmlXssDeserializer(String.class));
//        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().applicationContext(this.getApplicationContext()).build();
//        objectMapper.registerModule(module);
//        // 创建自定义消息转换器
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
//        //设置中文编码格式
//        List<MediaType> list = new ArrayList<>();
//        list.add(MediaType.APPLICATION_JSON_UTF8);
//        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
//        return mappingJackson2HttpMessageConverter;
//    }
//}