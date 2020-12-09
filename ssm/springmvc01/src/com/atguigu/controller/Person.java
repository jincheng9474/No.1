package com.atguigu.controller;

public class Person {
    private Integer id = 1;
    private Integer age = 18;
    private String name = "sx";
    private String phone = "120";
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", car=" + car +
                '}';
    }

    public Person() {
    }

    public Person(Integer id, Integer age, String name, String phone) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.phone = phone;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
