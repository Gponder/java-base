package com.gponder.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/22 17:23
 *
 * 共享锁 独享锁(互斥锁)
 * 读锁是可以和读锁共享的这样可以提高效率
 */
public class ReadWrite {
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void readLock(){
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getId()+"read lock:"+System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readWriteLock.readLock().unlock();
    }

    public void writeLock(){
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getId()+"read lock:"+System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readWriteLock.writeLock().unlock();
    }

    public void test1(){
        new Thread(()->readLock()).start();
        new Thread(()->readLock()).start();
    }

    public void test2(){
        new Thread(()->writeLock()).start();
        new Thread(()->writeLock()).start();
    }

    public void test3(){
        new Thread(()->readLock()).start();
        new Thread(()->writeLock()).start();
    }

    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();
        readWrite.test1();
        readWrite.test2();
        readWrite.test3();
    }
}
