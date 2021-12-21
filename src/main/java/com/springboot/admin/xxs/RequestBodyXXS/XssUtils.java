//package com.springboot.admin.xxs.RequestBodyXXS;
//
//import java.io.IOException;
//
//import org.owasp.esapi.ESAPI;
//import org.owasp.validator.html.AntiSamy;
//import org.owasp.validator.html.CleanResults;
//import org.owasp.validator.html.Policy;
//import org.owasp.validator.html.PolicyException;
//import org.owasp.validator.html.ScanException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//
///*
//* ESAPI 安装方式：下载Jar包，执行mvn install:install-file -Dfile=esapi-2.2.3.1.jar -DgroupId=com.ws.esapi -DartifactId=esapi -Dversion=1.0 -Dpackaging=jar命令
//*
//* */
//
//public class XssUtils {
//
//    private final static Logger logger = LoggerFactory.getLogger(XssUtils.class);
//
//    private static Policy policy = null;
//
//    static{
//        ResourceLoader resourceLoader = new DefaultResourceLoader();
//        Resource resource = resourceLoader.getResource("classpath:/antisamy-test.xml");
//        try {
//            policy = Policy.getInstance(resource.getURL().getPath());
//        } catch (PolicyException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String encode(String value){
//        if(value == null || value.length() == 0) {
//            return value;
//        }
//        value = ESAPI.encoder().canonicalize(value);
//        return ESAPI.encoder().encodeForHTML(value);
//    }
//
//    public static String[] encode(String[] values){
//        if(values == null || values.length == 0){
//            return values;
//        }
//        int len = values.length;
//        String[] _values = new String[len];
//        for(int i = 0; i < len; i++){
//            _values[i] = encode(values[i]);
//        }
//        return _values;
//    }
//
//    public static String clean(String value){
//        AntiSamy antiSamy = new AntiSamy();
//        try {
//            final CleanResults cr = antiSamy.scan(value, policy);
//            return cr.getCleanHTML();
//        } catch (ScanException | PolicyException e) {
//            logger.error("invoke xss clean error", e);
//        }
//        return value;
//    }
//
//    public static String[] clean(String[] values){
//        if(values == null || values.length == 0){
//            return values;
//        }
//        int len = values.length;
//        String[] _values = new String[len];
//        for(int i = 0; i < len; i++){
//            _values[i] = clean(values[i]);
//        }
//        return _values;
//    }
//
//}
