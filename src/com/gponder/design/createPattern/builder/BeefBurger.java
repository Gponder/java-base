package com.gponder.design.createPattern.builder;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/9 17:53
 */
public class BeefBurger extends Burger {
    @Override
    public double getPrice() {
        return 20.0;
    }

    @Override
    public String getName() {
        return "beef burger";
    }
}
