package com.gponder.character.java.serial;

import java.io.*;
import java.util.Arrays;

/**
 * 序列化是将Java对象转化为字节序列的过程
 * 1.用于RPC 示例rmi(Java在JDK1.2中实现)
 * 2.用于保存对象到文件用于恢复
 *
 * ObjectOutputStream
 * 序列化时对象中有引用类型也会涉及序列化深浅问题
 * private static final long serialVersionUID = -5809782578272943849L;
 * 不定义序列化版本时每次编译都会自动生成不同的序列化版本 第二次编译后无法再次进行对象还原
 */
public class ObjSerializable implements Serializable {

    private String s = "ObjSerializable";

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream objByte = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(objByte);
        objectOutputStream.writeObject(new ObjSerializable());
        System.out.println(Arrays.toString(objByte.toByteArray()));
        System.out.println("哈哈"+new String(objByte.toByteArray()));
    }
}
