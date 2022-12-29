package com.gponder.thread.sync.interrupt;

import java.util.Date;

/**
 * https://www.jb51.net/article/228777.htm
 * interrupt 可以中断sleep join wait 让线程从冻结状态强制恢复到运行状态中
 * 可以通过让线程出现interruptException让线程结束运行 stop()方法停止不安全也不稳定
 * interrupt只是改变中断状态，不会中断一个正在运行的线程；设置该线程的中断状态位，即设置为true；线程会不时地检测这个中断标示位
 * this.interrupted():测试当前线程是否已经中断（静态方法）。如果连续调用该方法，则第二次调用将返回false。
 */
public class Interrupt {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
                try {
                    Thread.sleep(1000*10);
                } catch (InterruptedException e) {
                    System.out.println("中断"+new Date());
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
