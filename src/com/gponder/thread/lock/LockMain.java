package com.gponder.thread.lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/21 14:56
 *
 * java 线程安全 Lock synchronized
 * 所有锁加锁和解锁次数必须一致否则会造成死锁,所以加锁解锁中间有try catch 解锁需要写在finally模块 这里只是测试并未严格遵守
 */
public class LockMain {

    /**
     * 公平锁/非公平锁
     * 可重入锁
     * 独享锁/共享锁
     * 互斥锁/读写锁
     * 乐观锁/悲观锁
     * 分段锁
     * 偏向锁/轻量级锁/重量级锁
     * 自旋锁
     * @param args
     */
    public static void main(String[] args) {
        cyclicBarrier();
    }

    /**
     * 可以在主线程wait在其他线程countDown
     * 也可以在多个线程wait在主线程countDown
     */
    private static void countDown() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(()->{
            try {
                countDownLatch.await();
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        countDownLatch.countDown();
    }

    private static void cyclicBarrier(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(()->{
            try {
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getId()+"start"+System.currentTimeMillis());
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getId()+"start"+System.currentTimeMillis());

                Thread.sleep(new Random().nextInt(1000));
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getId()+"start"+System.currentTimeMillis());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getId()+"start"+System.currentTimeMillis());
                Thread.sleep(new Random().nextInt(1000));
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getId()+"start"+System.currentTimeMillis());

                Thread.sleep(new Random().nextInt(1000));
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getId()+"start"+System.currentTimeMillis());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
