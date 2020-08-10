package com.gponder.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/8/6 17:14
 *
 * JVM 内存间交互操作
 * 主内存和工作内存 的可见性
 */
public class TestVolatile {

    private boolean flag = true;

    public static void main(String[] args) throws Exception {
        TestVolatile ts = new TestVolatile();
        ts.test();
        for (; ; ) {
            System.out.println("thread: " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
        }
    }

    public void test() throws Exception {
        Thread testThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (flag) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + ",flag:" + flag + "i:" + i);
                }
            }
        });
        testThread.start();
        TimeUnit.SECONDS.sleep(1);
        flag = false;
    }


}
