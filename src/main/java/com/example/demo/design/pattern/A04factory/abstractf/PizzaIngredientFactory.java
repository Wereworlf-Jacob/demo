package com.example.demo.design.pattern.A04factory.abstractf;

import com.example.demo.design.pattern.A04factory.abstractf.ingredients.*;

/**
 * 披萨原料工厂，当每种披萨需要不同的原料组成时，需要有原料工厂来专门生产配料
 * @auth Jacob
 * @date 2020/8/31 15:43
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClams();

}
