package com.gponder.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/22 0:18
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();//无限扩大的线程池
        Executors.newFixedThreadPool(5);//固定大小的线程池
        Executors.newSingleThreadExecutor();//单线程的线程池
        Executors.newScheduledThreadPool(5);//适用于执行延时或者周期性任务
    }
}
