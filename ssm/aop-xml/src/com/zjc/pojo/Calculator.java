package com.zjc.pojo;


public class Calculator implements Calculate {

    public int add(int num1, int num2) {
        System.out.println("执行目标方法 public int add(int num1, int num2)");
        int result = (int) (num1 + num2);
        return result;
    }

    public int add(int num1, int num2, int num3) {
        System.out.println("执行目标方法 public int add(int num1, int num2, int num3)");
        int result = num1 + num2 + num3;
        return result;
    }

    public int div(int num1, int num2) {

        System.out.println("执行目标方法  public int div(int num1, int num2) ");
        int result = num1 / num2;
        return result;

    }
}
