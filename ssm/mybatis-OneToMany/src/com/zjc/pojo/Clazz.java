package com.zjc.pojo;

import java.util.List;

public class Clazz {
    private Integer id;
    private String name;
    private List<Student> stuList;



    public Clazz(Integer id, String name, List<Student> stuList) {
        this.id = id;
        this.name = name;
        this.stuList = stuList;
    }

    public Clazz() {
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

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stuList=" + stuList +
                '}';
    }
}
