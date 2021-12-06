package com.springboot.admin.test.testProxy;

public class PersonImpl implements Person {
    @Override
    public void say() {
        System.out.println("你好");
    }

    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    public void play(){
        System.out.println("玩耍");
    }

}
