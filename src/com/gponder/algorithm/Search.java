package com.gponder.algorithm;

import java.util.Arrays;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/5 14:50
 *  搜索算法
 */
public class Search {
    /**
     *  二分法查找
     * @param array    从小到大排序过的数组
     * @param num   查找值
     * @return  下标
     */
    public int binarySearch(int[] array,int num){
        int start=0;
        int end = array.length-1;
        while (array[(end-start)/2]!=num){
            if (num>array[end/2]){
                start = (end-start)/2;
            }else{
                end = (end-start)/2;
            }
        }
        return (end-start)/2;
    }

    public void testBinarySearch(){
        int[] array = {1,2,3,4,5,6,7,8,9};
        int index = binarySearch(array, 3);
        System.out.println(index==2);
    }

    public static void main(String[] args) {
        new Search().testBinarySearch();
        int[] array = {1,2,3,4,5,6,7,8,9};
        int index = Arrays.binarySearch(array, 3);
    }
}
