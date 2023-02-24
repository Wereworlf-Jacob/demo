package com.example.demo.design.pattern.A04factory;

import java.util.ArrayList;

/**
 * 抽象的披萨类，所有具体的披萨都必须派生自这个类
 * @auth Jacob
 * @date 2020/8/4 10:02
 */
public abstract class Pizza {

    protected String name;//披萨名称
    protected String dough;// 披萨面团
    protected String sauce;// 披萨酱料
    //一套佐料
    protected ArrayList toppings = new ArrayList();

    //准备出来一个完整的披萨
    public void prepare(){
        System.out.println("Preparing " + name); //准备一个披萨
        System.out.println("Tossing dough: " + dough); //揉成一个面饼
        System.out.println("Add sauce: " + sauce); //添加一些酱料
        System.out.println("Add topping："); //把上面的佐料都撒上
        for (Object topping : toppings) {
            System.out.println(" " + topping);
        }
    }

    //披萨进行烘焙
    public void bake() {
        //350度烘焙25分钟
        System.out.println("Bake for 25 minutes at 350");
    }

    //披萨切片
    public void cut() {
        //披萨切成角块
        System.out.println("Cutting the pizza into diagonal slices");
    }

    //披萨装盘
    public void box() {
        //把披萨放在披萨店官方的盒子里
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
