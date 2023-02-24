package com.example.demo.design.pattern.A04factory.abstractf;

/**
 * 纽约的披萨店
 * @auth Jacob
 * @date 2020/8/31 16:02
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    public AbstractPizza createPizza(String type) {
        AbstractPizza pizza;
        PizzaIngredientFactory factory = new NYPizzaIngredientFactory();
        if ("cheese".equals(type)) {
            pizza = new CheesePizza(factory);
            pizza.setName("New York Style Cheese Pizza");
            return pizza;
        }
        return null;
    }
}
