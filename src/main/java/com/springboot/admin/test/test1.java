package com.springboot.admin.test;

import com.springboot.admin.model.User;
import org.testng.annotations.Test;

public class test1 {

    @Test
    public void test1() {
        String str = "NXWLT:WEB:ATTEMPTS_%s";
        String username = "guoan";
        String newStr = String.format(str, username);
        System.out.println(newStr);
        //lombok  建造者模式
        User user = User.builder().userId(10).userName("aaa").build();
    }

}
