package com.gponder.design.createPattern.builder;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/9 17:54
 */
public class ChickenBurger extends Burger{

    @Override
    public double getPrice() {
        return 15.0;
    }

    @Override
    public String getName() {
        return "chicken burger";
    }
}
