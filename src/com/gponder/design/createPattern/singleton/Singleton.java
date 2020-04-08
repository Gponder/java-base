package com.gponder.design.createPattern.singleton;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/5 15:33
 * 单例模式
 */
public class Singleton {

    private Singleton() {
    }

    private static Singleton singleton;

    public static synchronized Singleton getInstance(){
        if (singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
