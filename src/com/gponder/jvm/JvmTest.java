package com.gponder.jvm;

import com.gponder.algorithm.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author gponder
 * @Email gponder.g@gmail.com
 * @create 2020/3/23 16:37
 *
 *
 */
public class JvmTest {


    public static void main(String[] args) {
        JvmTest jvmTest = new JvmTest();
        jvmTest.heap();
    }

    private int size = 102400000;



    /**
     * 堆溢出
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */
    private void heap() {
        int[] array = new int[size];
        Random random = new Random();
        for (int i=0;i<size;i++){
            array[i] = random.nextInt(size);
        }
        new Sort().quickSort(array,0,size-1);
        System.out.println(Arrays.toString(array));
    }

}
