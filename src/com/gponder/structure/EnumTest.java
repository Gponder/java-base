package com.gponder.structure;

import java.util.Arrays;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(ColorEnum.RED);
        System.out.println(ColorEnum.valueOf("RED"));
        System.out.println(ColorEnum.RED.ordinal());
        System.out.println(ColorEnum.RED.name());
        System.out.println(Arrays.toString(ColorEnum.values()));
    }
}
