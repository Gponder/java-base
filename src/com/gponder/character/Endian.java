package com.gponder.character;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Endian {
    public static void main(String[] args) {
        int i = 0x12345678;
        System.out.println(i>>24==0x12);//大端
        System.out.println(ByteOrder.nativeOrder());//x86小端
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[4]);
        byteBuffer.asIntBuffer().put(i);
        System.out.println(Arrays.toString(byteBuffer.array()));
        System.out.println(byteBuffer.order());
        //设置为小端
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.asIntBuffer().put(i);
        System.out.println(Arrays.toString(byteBuffer.array()));
    }
}
