package com.gponder.design.createPattern.singleton;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/8 14:37
 */
public class Singleton2 {

    private Singleton2() {
    }

    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2 getInstance(){
        return singleton2;
    }
}
