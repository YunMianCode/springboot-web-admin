package com.springboot.admin;


import com.springboot.admin.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class test1 {

//    @Value(${my.random})
    private int randomValue;

    @Test
    public void test1(){
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootWebAdminApplication.class);
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(randomValue);
        System.out.println(car.getRandomValue());
    }

}
