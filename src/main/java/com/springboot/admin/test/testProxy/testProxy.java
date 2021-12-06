package com.springboot.admin.test.testProxy;

import java.lang.reflect.Proxy;

public class testProxy {

    public static void main(String[] args) {
        Person proxyInstance = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, new MyHandler(new PersonImpl()));
        proxyInstance.say();
    }

}
