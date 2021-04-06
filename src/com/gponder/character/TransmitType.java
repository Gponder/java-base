package com.gponder.character;

import java.util.Date;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/12/7 17:20
 *
 * 传递类型
 *  其实传递的是指针指向的内存地址 该地址数据的变化可以被感知,指针引用的改变不可以被感知
 *
 *
 * 与final的区别
 *
 */
public class TransmitType {
    public static void main(String[] args) {
        TransmitType transmitType = new TransmitType();
        transmitType.test1();
        transmitType.test2();
        transmitType.test3();
        transmitType.test31();
    }

    public void test1(){
        int a = 0;
        base(a);
        System.out.println(a);
    }

    public void base(int a){
        a = a+1;
    }

    public void test2(){
        String s = "s";
        ref(s);
        System.out.println(s);
    }

    public void ref(String s){
        s = s+"1";
    }

    public void test3(){
        Data d = new Data();
        d.setValue(1);
        object(d);
        System.out.println(d.getValue());
    }

    public void object(Data data){
        data.setValue(2);
    }

    class Data{
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public void test31(){
        Data d = new Data();
        d.setValue(1);
        object1(d);
        System.out.println(d.getValue());
    }

    public void object1(Data data){
        data = new Data();
        data.setValue(31);
    }

    public void pack(Integer integer){
        //无法改变integer的值
    }

    public void testFinal(String s){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(s);
            }
        }).run();
    }

}
