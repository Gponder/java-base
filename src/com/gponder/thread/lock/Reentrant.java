package com.gponder.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/22 14:26
 *
 *  可重入锁:同一个线程可以在不解锁情况下多次上锁
 *  synchronised ReentrantLock
 *
 *  https://tech.meituan.com/2019/12/05/aqs-theory-and-apply.html
 *  ReentrantLock
 *  AQS 核心思想是，如果被请求的共享资源空闲，则将当前请求资源的线程设置为有效的工作线程，并且将共享资源设置为锁定状态。如果被请求的共享资源被占用，那么就需要一套线程阻塞等待以及被唤醒 时锁分配的机制，这个机制 AQS 是用 CLH 队列锁实现的，即将暂时获取不到锁的线程加入到队列中。
 */
public class Reentrant {

    ReentrantLock reentrantLock = new ReentrantLock();

    public void reentrant() {
        int i = 0;
        while (i < 5) {
            reentrantLock.lock();
            System.out.println(reentrantLock + ":" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void invoke() {
        new Thread(() -> {
            this.reentrant();
        }).start();
    }

    public static void main(String[] args) {
        Reentrant reentrant = new Reentrant();
        reentrant.invoke();//当前线程可以多次重入
        reentrant.invoke();//不同线程不可重入,因为没有解锁
    }


    /**
     * 不可重入锁
     */
    public class Lock {
        private boolean isLocked = false;

        public synchronized void lock() throws InterruptedException {
            while (isLocked) {
                wait();
            }
            isLocked = true;
        }

        public synchronized void unlock() {
            isLocked = false;
            notify();
        }

    }
}
