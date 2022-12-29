package com.gponder.thread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/18 20:02
 *
 * countDown()的线程并不会阻塞 需要同时执行的线程需要 await() 也可以先countDown再await
 */
public class ThreadMain {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new CountDownA(countDownLatch).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new CountDownB(countDownLatch).start();
        new CountDownB(countDownLatch).start();
    }

    static class CountDownA extends Thread{
        CountDownLatch countDownLatch;

        public CountDownA(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            setName("CountDownA");
        }

        @Override
        public void run() {
            System.out.println(getName()+new Date());
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"end"+new Date());
        }
    }

    static class CountDownB extends Thread{
        CountDownLatch countDownLatch;

        public CountDownB(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            setName("CountDownB");
        }

        @Override
        public void run() {
            System.out.println(getName()+new Date());
            try {
                Thread.sleep(new Random().nextInt(10) *1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"end"+new Date());
        }
    }
}
