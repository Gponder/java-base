package com.gponder.thread.sync.join;

/**
 * https://www.jianshu.com/p/fc51be7e5bc0
 */
public class Join extends Thread{

    Thread theThread;
    int i;

    public Join(Thread theThread, int i) {
        this.theThread = theThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            theThread.join();
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num:"+i);
    }

    public static void main(String[] args) {
        Thread previousThread=Thread.currentThread();
        for (int i=0;i<10;i++){
            Join join = new Join(previousThread, i);
            System.out.println("number:"+i);
            join.start();
            previousThread = join;
        }
    }
}
