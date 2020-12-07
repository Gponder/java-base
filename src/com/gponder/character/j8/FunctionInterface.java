package com.gponder.character.j8;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/5 15:19
 *
 * 函数式接口
 */
public class FunctionInterface {

    public FunctionInterface() {
    }

    /**
     * 参数 -> 方法体
     * 参数可以加() 传多个参数， 方法体可以加{} 写多行代码
     */
    void forEach(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.forEach(item->{
            System.out.println(item);
        });
    }

    @FunctionalInterface
    interface J8Interface {
        void print(String s);
        default void printDefault(int i){
            System.out.println("default");
        }
        static void printStatic(){
            System.out.println("static");
        }
    }

    class J8 implements  J8Interface {

        @Override
        public void print(String s) {

        }

        @Override
        public void printDefault(int i) {

        }
    }

    public static void main(String[] args) {
        new FunctionInterface().forEach();
    }
}
