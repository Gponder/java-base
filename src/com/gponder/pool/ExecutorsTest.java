package com.gponder.pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

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
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(10000);
                Map<String,String> map = new HashMap<>();
                map.put("call","callable");
                map.put("threadName",Thread.currentThread().getName());
                map.put("threadId", String.valueOf(Thread.currentThread().getId()));
                return map;
            }
        });
        try {
            //阻塞 直到callable执行完返回数据
            Object object = future.get();
            System.out.println(object.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
