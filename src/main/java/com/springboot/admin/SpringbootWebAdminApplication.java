package com.springboot.admin;

import com.springboot.admin.common.annoation.EnableFormValidator;
import com.springboot.admin.model.Car;
import org.apache.catalina.core.ApplicationContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.admin.**")
@MapperScan("com.springboot.admin.**.dao")
@EnableScheduling
@ServletComponentScan(basePackages = "com.springboot.admin")
@EnableFormValidator
public class SpringbootWebAdminApplication {

	public static void main(String[] args) {
//		SpringApplication application = new SpringApplication(SpringbootWebAdminApplication.class);
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootWebAdminApplication.class);
		Car car = (Car) applicationContext.getBean("car");
		System.out.println(car.getRandomValue());
	}

}
