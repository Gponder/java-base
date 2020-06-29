package com.gponder.operator;

public class JvmOperator {

    /**
     * 位操作
     * 左移一位 *2
     * 右移一位 /2
     * int i = 0b11111111111111111111111111111111;// 0-1 = -1
     * i = 0b11111111111111111111111111111110;// -2
     * i = 0b10000000000000000000000000000000;// Integer.MIN_VALUE = -2147483648
     * i = 0b01111111111111111111111111111111;// Integer.MAX_VALUE = 2147483647
     * i = 0b00000000000000000000000000000001;// 1
     *
     * >>（右移运算符）    向右移动除符号位的位 左侧补符号  负数移动后仍是负数
     * >>>（无符号右移）    表示带符号向右移动 前面统统补0  负数移动后变成正数
     */
    public void bit(){
        outHex(-1>>16);
        outHex(-1>>>16);
        outHex(-1>>>30);
        outHex(-1>>>31);
        outHex(-1>>>32);
        outHex(-1>>>33);
    }

    public void or(){
        System.out.println(1|0);
        System.out.println(1|1);
        System.out.println(0|0);
    }

    public void and(){
        System.out.println(1&0);
        System.out.println(1&1);
        System.out.println(0&0);
    }

    /**
     * 相同为0 不同为1
     */
    public void notOr(){
        System.out.println(1^0);
        System.out.println(1^1);
        System.out.println(0^0);

        System.out.println(1^0^0);
        System.out.println(1^1^1);
    }

    public void outHex(int i){
        System.out.println(Integer.toHexString(i));
    }

    public static void main(String[] args) {
        JvmOperator jvmOperator = new JvmOperator();
        //jvmOperator.bit();
        //jvmOperator.or();
        //jvmOperator.and();
        jvmOperator.notOr();
    }
}
