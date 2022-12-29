package com.gponder.thread.sync;

public class MultiThread {

    static volatile int num = 0;

    public static void main(String[] args) {
        for (int i=0;i<500;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    num ++;
                }
            }).start();
            System.out.println(num);
        }
    }
}
