package com.zjc.pojo;

public class Person {
    private Integer id;
    private String name;
    private String phone;
    private Double salary;
    private Car car;

    public Person(Integer id, String name, String phone, Double salary, Car car) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
        this.car = car;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

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
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }
}
