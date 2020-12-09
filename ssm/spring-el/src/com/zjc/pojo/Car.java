package com.zjc.pojo;

public class Car {
    private String name;
    private String carNo;

    public String noStaticFun(){
        System.out.println("好爱好爱你，xxx noStaticFun() ");
        return "爱你一万年";
    }

    public static String staticFun(){
        System.out.println(" 你为什么要伤害我 ");
        return "蒙蒙";
    }

    public Car(String name, String carNo) {
        this.name = name;
        this.carNo = carNo;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carNo='" + carNo + '\'' +
                '}';
    }
}
