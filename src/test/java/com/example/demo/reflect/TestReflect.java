package com.example.demo.reflect;

import java.lang.reflect.Method;

/**
 * @ClassName TestReflect
 * @Description 反射功能的测试类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/28 10:23
 **/
public class TestReflect {

    public static void main(String[] args) {
        try {
            Method method = Student.class.getMethod("toString", new Class[]{});
            //返回声明该方法的类信息，比如getName是student的方法，那么值= student
            //如果是toString方法，如果student没有重写，那么值= Object，如果重写了，那么值还是student
            System.out.println(method.getDeclaringClass());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
