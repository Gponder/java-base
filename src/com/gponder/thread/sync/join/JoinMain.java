package com.gponder.thread.sync.join;

/**
 * join可以控制线程的执行顺序
 * thread.join()意思是插队 阻塞当前线程 让join的线程先执行完在执行当前线程
 * join方法内调用了Thread.wait()实现
 */
public class JoinMain {

    public static void main(String[] args) {
        //join();
        join2();
    }

    private static void join2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        synchronized (thread){
            try {
                while (thread.isAlive()){
                    thread.wait(0);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end");
    }

    private static void join() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
