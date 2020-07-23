package com.gponder.pool;

import java.util.concurrent.*;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/21 21:43
 */
public class DefaultThreadPool {

    /**
     * submit 有返回值 {@link Future｝
     * @param args
     */
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,8,15, TimeUnit.MINUTES,new LinkedBlockingDeque<>());
        for (int i=0;i<100;i++)
        threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("he he"+ Thread.currentThread().getId());
                return null;
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                
            }
        });
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//异常处理  饱和策略分为：Abort 策略, CallerRuns 策略,Discard策略，DiscardOlds策略。
        threadPoolExecutor.setThreadFactory(Executors.defaultThreadFactory());//线程工厂
    }

}
