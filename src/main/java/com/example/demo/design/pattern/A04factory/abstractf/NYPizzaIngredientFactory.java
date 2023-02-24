package com.example.demo.design.pattern.A04factory.abstractf;

import com.example.demo.design.pattern.A04factory.abstractf.ingredients.*;

/**
 * @auth Jacob
 * @date 2020/8/31 15:48
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough(); //提供了纽约风味面皮
    }

    @Override
    public Sauce createSauce() { //提供了纽约风味酱料
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() { // 提供了纽约风味芝士
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = new Veggies[4];
        veggies[0] = new Garlic();
        veggies[1] = new Onion();
        veggies[2] = new Mushroom();
        veggies[3] = new RedPepper();
        return veggies;  //蔬菜数组
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni(); //切片的意式腊肠，纽约和芝加哥都会用到它
    }

    @Override
    public Clams createClams() {
        return new FreshClams(); //纽约靠海所有有新鲜的蛤蜊，芝加哥只能用冷冻蛤蜊
    }
}
