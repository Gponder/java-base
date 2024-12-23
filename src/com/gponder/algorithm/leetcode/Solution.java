package com.gponder.algorithm.leetcode;


import java.util.Arrays;

/**
 * TODO:必须加入类功能描述  
 *
 * @author 高亚钦
 * @date 2024/12/23 17:41
 * @version V1.0
 */
class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m=3,n=3;

        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m || j<n){
            if(i==m){
                nums[k] = nums2[j] ;
                j++;
                k++;
                continue;
            }
            if(j==n){
                nums[k] = nums1[i];
                i++;
                k++;
                continue;
            }
            if(nums1[i] < nums2[j]){
                nums[k] = nums1[i];
                i++;
            }else{
                nums[k] = nums2[j] ;
                j++;
            }
            k++;
        }
        for (int l=0;l<nums.length;l++){
            nums1[l] = nums[l];
        }
    }
}