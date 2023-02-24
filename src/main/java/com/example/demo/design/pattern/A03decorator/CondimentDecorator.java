package com.example.demo.design.pattern.A03decorator;

/**
 * 调味品装饰器，调味品也是属于饮料的一部分，所以要继承自饮料类
 * @auth Jacob
 * @date 2020/8/3 11:18
 */
public abstract class CondimentDecorator extends Beverage {

    //每种调味品，都要重写获取描述的方法，来说明自己是什么成分
    @Override
    public abstract String getDecscription();
}
