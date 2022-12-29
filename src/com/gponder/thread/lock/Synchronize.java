package com.gponder.thread.lock;

/**
 * 修饰实例方法：作用于当前实例加锁
 * 修饰静态方法：作用于当前类对象加锁
 * 修饰代码块：指定加锁对象，对给定对象加锁
 */
public class Synchronize {

    /**
     * {@link Synchronize#getClass()}
     */
    public static synchronized void lockClass(){

    }

    /**
     * this
     */
    public synchronized void lockObject(){

    }

    /**
     * lock
     */
    public void lockBlock(Object lock){
        synchronized (lock){

        }
    }
}
