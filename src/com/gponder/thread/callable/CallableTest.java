package com.gponder.thread.callable;


import java.util.concurrent.*;

/**
 * Callable与线程池使用
 * Callable 转换为FutureTask可以与线程使用
 *
 */
public class CallableTest {
    static Callable<String> callable = new Callable<String>() {
        @Override
        public String call() throws Exception {
            return "callable finished";
        }
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        threadCallable();
        poolCallable();
        completableFuture();
    }

    private static void completableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{return "completableFuture finished";});
        completableFuture.thenAccept(System.out::println);
//        System.out.println(completableFuture.get());
//        System.out.println(completableFuture.join());
    }

    private static void poolCallable() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> fu = executor.submit(callable);
        System.out.println(fu.get());
    }

    private static void threadCallable() throws InterruptedException, ExecutionException {

        FutureTask<String> futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();

        System.out.println(futureTask.get());
    }
}
