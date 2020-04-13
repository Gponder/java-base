package com.gponder.design.createPattern.builder;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/9 17:49
 */
public abstract class Drink implements Food {
    @Override
    public Packing getPacking() {
        return new CupPacking();
    }
}
