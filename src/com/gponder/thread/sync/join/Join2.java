package com.gponder.thread.sync.join;

public class Join2 {
    static class A extends Thread{

        public A() {
            setName("A");
        }

        @Override
        public void run() {
            for (int i=0;i<5;i++){
                try {
                    System.out.println(getName()+"="+i);
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(getName()+"end");
        }
    }

    static class B extends Thread{

        Thread t;

        public B(Thread t) {
            this.t = t;
            setName("B");
        }

        @Override
        public void run() {
            System.out.println(getName()+"start");
            try {
                t.join();
                System.out.println(getName()+"end");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new A();
        Thread b = new B(a);
        a.start();
        try {
            a.sleep(2000);
            b.start();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
