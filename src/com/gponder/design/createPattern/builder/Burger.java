package com.gponder.design.createPattern.builder;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/9 17:33
 */
public abstract class Burger implements Food {

    @Override
    public Packing getPacking() {
        return new PaperPacking();
    }

}
