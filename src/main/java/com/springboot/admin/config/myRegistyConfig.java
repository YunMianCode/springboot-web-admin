package com.springboot.admin.config;

import com.springboot.admin.filter.myFilter;
import com.springboot.admin.servlet.testServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class myRegistyConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        testServlet servlet = new testServlet();
        return new ServletRegistrationBean(servlet,"/my","/my1");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        myFilter filter = new myFilter();
//        return new FilterRegistrationBean(filter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my2","/my3"));
        return filterRegistrationBean;
    }

}
