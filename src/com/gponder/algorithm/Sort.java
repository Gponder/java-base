package com.gponder.algorithm;

import java.util.Arrays;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/5 14:51
 * 排序算法
 */
public class Sort {

    /**
     * 冒泡排序
     * 相邻元素比较 找出最小的放在一端
     */
    public int[] bubble(int[] array){
        int temp;
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length-i-1;j++){
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public void bubbleTest() {
        int[] array = {6,4,3,2,7,8,9,1,5};
        System.out.println(Arrays.toString(bubble(array)));
    }

    /**
     * 快速排序 空间换时间
     * 先操作j可能造成j=-1，此时后操作的i
     * @param array
     * @param left
     * @param right
     */
    public void quickSort(int[] array,int left,int right){
        if (left>=right)return;
        int i=left;
        int j=right;
        int base = array[left];
        int temp;
        while (i<j){
            while (array[j]>=base && i<j){
                j--;
            }
            while (array[i]<=base && i<j){
                i++;
            }
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
        temp = array[left];
        array[left] = array[i];
        array[i] = temp;
        //System.out.println(Arrays.toString(array)+left+right);
        quickSort(array,left,j-1);
        quickSort(array,j+1,right);
    }

    public void quickSortTest(){
        int[] array = {6,4,3,2,7,8,9,1,5};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     * 依次吧未排序的元素插入到排序过的元素中
     * @param array
     */
    public void insertSort(int[] array){
        int temp;
        for (int i=1;i<array.length;i++){
            for (int j=i;j>0;j--){
                if (array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    public void insertSortTest(){
        int[] array = {6,4,3,2,7,8,9,1,5};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        //冒泡测试
        sort.bubbleTest();
        //快排测试
        sort.quickSortTest();
        //插入测试
        sort.insertSortTest();
        //jdk排序实现
        int[] array2 = {6,4,3,2,7,8,9,1,5};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }
}
