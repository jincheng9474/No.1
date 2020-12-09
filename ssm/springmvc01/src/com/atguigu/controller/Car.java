package com.atguigu.controller;

public class Car {
    private String carNo = "1";
    private String carType = "525";

    public Car() {
    }

    public Car(String carNo, String carType) {
        this.carNo = carNo;
        this.carType = carType;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNo='" + carNo + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
