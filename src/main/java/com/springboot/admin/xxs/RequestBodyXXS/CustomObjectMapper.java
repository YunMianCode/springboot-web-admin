//package com.springboot.admin.xxs.RequestBodyXXS;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//
//
//public class CustomObjectMapper extends ObjectMapper {
//    private static final long serialVersionUID = -8543006375974774016L;
//
//    public CustomObjectMapper(){
//        SimpleModule simpleModule = new SimpleModule();
//        //序列化与反序列化字符串，使用了xss clean
//        simpleModule.addSerializer(String.class, StringSerializer.instance);
//        simpleModule.addDeserializer(String.class, StringDeserializer.instance);
//
//        this.registerModule(simpleModule);
//    }
//}
