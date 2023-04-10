package com.gponder.algorithm.leetcode;

import java.util.HashMap;

public class Q1Sum {

    private void sum(int[] arr,int sum){
        System.out.println(sum);
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]+arr[j] == sum){
                    System.out.println(i+"->"+arr[i]);
                    System.out.println(j+"->"+arr[j]);
                }
            }
        }
    }

    public void case1() {
        int[] nums = {2,7,11,15};
        int sum = 9;
        sum(nums,sum);
        sum2(nums,sum);
        nums = new int[]{3, 2, 4};
        sum = 6;
        sum(nums,sum);
        sum2(nums,sum);
        nums = new int[]{3,3};
        sum = 6;
        sum(nums,sum);
        sum2(nums,sum);
    }

    private void sum2(int[] arr,int sum){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (map.containsKey(sum-arr[i])){
                System.out.println(i+"-"+map.get(sum-arr[i]));
            }
            map.put(arr[i],i);
        }
    }

}
