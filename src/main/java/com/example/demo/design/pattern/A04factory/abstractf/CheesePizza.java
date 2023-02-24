package com.example.demo.design.pattern.A04factory.abstractf;

/**
 * @auth Jacob
 * @date 2020/8/31 15:58
 */
public class CheesePizza extends AbstractPizza {

    PizzaIngredientFactory factory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        factory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing" + name);
        //神奇的地方在这里，prepare方法一步一步地创建芝士披萨，每当需要原料时，就跟工厂要
        dough = factory.createDough();
        sauce = factory.createSauce();
        cheese = factory.createCheese();
        factory.createPepperoni();
    }
}
