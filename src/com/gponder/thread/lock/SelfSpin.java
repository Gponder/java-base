package com.gponder.thread.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/23 11:36
 *
 * 自旋锁  -XX:+UseSpinning 参数控制开关1.6之后默认开启
 */
public class SelfSpin {

    SelfSpinningLock selfSpinningLock = new SelfSpinningLock();

    public void selfSpin(){
        selfSpinningLock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+System.currentTimeMillis());
        selfSpinningLock.unLock();
    }

    public void runInThread(){
        new Thread(()->{
            selfSpin();
        }).start();
    }

    public static void main(String[] args) {
        SelfSpin self = new SelfSpin();
        self.runInThread();
        self.runInThread();
    }

    class SelfSpinningLock{

        AtomicReference<Thread> atomicReference = new AtomicReference<>();

        public void lock(){
            while (!atomicReference.compareAndSet(null,Thread.currentThread())){
            }
        }

        public void unLock(){
            if (atomicReference.get()!=Thread.currentThread()){
                throw new RuntimeException("当前线程没有上锁");
            }
            atomicReference.set(null);
        }
    }
}
