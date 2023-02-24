package com.example.demo.design.pattern.A04factory.abstractf;

import com.example.demo.design.pattern.A04factory.abstractf.ingredients.*;

import java.util.ArrayList;

/**
 * 重做的抽象披萨类，普通Pizza类的升级
 * @auth Jacob
 * @date 2020/8/31 15:54
 */
public abstract class AbstractPizza {
    protected String name;//披萨名称
    protected Dough dough;// 披萨面团
    protected Sauce sauce;// 披萨酱料
    //一套佐料
    protected ArrayList toppings = new ArrayList();

    protected Veggies[] veggies;

    protected Cheese cheese;

    protected Pepperoni pepperoni;

    protected Clams clams;
    //准备出来一个完整的披萨
    abstract void prepare();

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

    @Override
    public String toString() {
        //这里是打印输出披萨的地方
        return "AbstractPizza{" +
                "name='" + name + '\'' +
                ", dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", toppings=" + toppings +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clams=" + clams +
                '}';
    }
}
