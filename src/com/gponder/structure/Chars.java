package com.gponder.structure;

public class Chars {
    public static void main(String[] args) {
//        for (char i = 0; i<65535; i++){
        for (char i = 12448; i<12543; i++){
            System.out.print(i);
            if (i%100==0) {
                System.out.println(Integer.valueOf(i));
            }
        }
    }
}
