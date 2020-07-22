package com.gponder.thread.lock;

import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/21 14:57
 *
 * 公平锁/非公平锁
 */
public class Fair {
    ReentrantLock reentrantLock = new ReentrantLock(false);

    public void fairLock(){
        try {
            reentrantLock.lock();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        Fair f = new Fair();
        for (int i=0;i<10;i++){
            Thread t = new Thread(() -> {
                f.fairLock();
            });
            t.setName(String.valueOf(i));
            t.start();
        }
    }










    static HashMap<String,Object> map = new HashMap<>();
    static Fair fair = new Fair();

    public static void mm(String[] args) {
        new Thread(()->{
            fair.runA();
        }).start();
        new Thread(()->{
            fair.runB();
        }).start();
    }

    public void runA(){
        reentrantLock.lock();
        try {
            map.put("string","a");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(map.get("string").toString()+System.currentTimeMillis());
            reentrantLock.unlock();
        }
    }

    public void runB(){
        reentrantLock.lock();
        try {
            map.put("string","b");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(map.get("string").toString()+System.currentTimeMillis());
            reentrantLock.unlock();
        }
    }
}
