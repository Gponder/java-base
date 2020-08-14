package com.gponder.structure;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/8/14 9:32
 */
public class StringTrait {
    public static void main(String[] args) {
        StringTrait stringTrait = new StringTrait();
        stringTrait.testIntern();
    }

    public void test(){
        String s1 = "a";
        String s2 = "a";
        System.out.println(s1==s2);
        String s3 = "abc"+"d";
        String s4 = "ab"+"cd";
        System.out.println(s3==s4);
        String s6 = "abcd";
        System.out.println(s3==s6);
        String s5 = new String("abcd");
        System.out.println(s3==s5);
    }

    /**
     * 直接+ 和赋值之后+是不一样的 直接+在编译阶段已经优化
     * 包涵变量的+ 会在堆中创建
     * 通过intern在常量池中创建
     * 程序成定义的会在常量池中
     */
    public static void testY(){
        String s1 = "1234";

        String s01 = "123";

        String s02 = "4";

        String s2 = s01 + s02;

        System.out.println(s1 == s2);
    }

    /**
     * intern（）
     * 查看常量池中是否有字符串有则返回引用，无则创建返回引用
     */
    public void testIntern(){
        String s1 = "abcd".intern();
        String s2 = "abcd".intern();
        System.out.println(s1==s2);
        String s01 = "abc";
        String s02 = "d";
        String s3 = s01+s02;
        String s4 = "abcd";
        System.out.println(s3==s4);
        s3 = s3.intern();
        System.out.println(s3==(s4));
    }
}
