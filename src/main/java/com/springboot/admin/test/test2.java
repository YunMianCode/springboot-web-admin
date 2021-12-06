package com.springboot.admin.test;

public class test2 {

    public static void main(String[] args) {
        int i = function1();
        System.out.println(i);
    }

    public static int function1(){
        int sum = 0;
        try {
            int i = 10;
            int j = 10 / 0;
        }catch (Exception e){
            e.printStackTrace();
//            return sum = 10;
        }finally {
            sum=20;
        }
        return sum;
    }

}
