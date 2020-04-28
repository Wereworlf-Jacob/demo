package com.example.demo.reflect;

/**
 * @ClassName Student
 * @Description 学生类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/28 10:24
 **/
public class Student {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
