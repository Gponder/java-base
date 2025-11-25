package com.gponder.algorithm.leetcode;


import java.util.Arrays;

/**
 *
 *
 * @author
 * @date 2024/12/23 17:41
 * @version V1.0
 */
class Solution {
    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2,3,0,0,0};
//        int[] nums2 = new int[]{2,5,6};
//        int m=3,n=3;
//        merge(nums1,m,nums2,n);

//        int[] nums1 = new int[]{0,1,2,2,3,0,4,2};
//        int length = removeElement(nums1, 2);

//        int[] nums1 = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] nums1 = new int[]{1,1,2,3};
//        int length = removeDuplicates(nums1);

//        int[] nums1 = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] nums1 = new int[]{1,1,1,2,2,3};
//        int[] nums1 = new int[]{0,0,1,1,1,1,2,3,3};
//        int length = removeDuplicates2(nums1);
//        System.out.println(Arrays.toString(nums1));


//        int[] nums1 = new int[]{3,2,3};
//        int[] nums1 = new int[50000];
//        int[] nums1 = new int[50000];
//        Arrays.fill(nums1, 1);
//        int[] nums = new int[]{1,2,3,4,5,6,7};
//        int k = 3;

//        int[] nums = new int[]{-1};
//        int k = 2;
//        rotate(nums, k);

//        int[] nums = new int[]{7,1,5,3,6,4};
        int[] nums = new int[]{983,341,957,541,470,660,118,742,334,822,165,145,730,656,567,25,684,113,351,295,468,918,587,4,399,220,11,222,777,127,135,688,267,570,342,748,382,428,340,35,896,846,376,655,147,891,198,420,729,685,989,543,285,822,254,878,380,758,490,73,870,328,234,489,990,387,688,12,795,746,275,371,321,298,186,925,845,816,775,647,379,15,602,756,619,256,106,312,965,661,973,147,437,796,56,955,846,245,502,889,557,281,936,812,880,880,834,186,303,96,706,634,464,232,170,188,527,637,847,293,726,146,441,973,380,61,956,599,626,206,284,815,36,591,166,690,454,700,458,808,410,252,365,953,650,609,438,106,582,82,925,847,800,128,615,440,956,142,488,350,474,762,435,37,970,850,260,893,996,321,9,884,581,783,41,157,650,815,644,558,320,267};
//        int[] nums = new int[]{1,2,4};
        System.out.println(maxProfit(nums));

    }

    public static int maxProfit(int[] prices){
        return maxProfit2(prices,prices.length-1);
    }

    public static int maxProfit2(int[] prices,int length) {
        int useIndex = 0;
        boolean isRise = false;
        for (int i = 0; i < length; i++) {
            if (prices[i+1] > prices[i]){
                if (!isRise){
                    prices[useIndex] = prices[i];
                    useIndex++;
                }
                isRise = true;
            }else{
                if (isRise){
                    prices[useIndex] = prices[i];
                    useIndex++;
                }
                isRise = false;
            }
        }
        if (prices[prices.length-1] > prices[useIndex-1]){
            prices[useIndex] = prices[prices.length-1];
            useIndex++;
        }
        if (useIndex<=3){
            return prices[useIndex]-prices[useIndex-1];
        }else {
            return maxProfit2(prices,useIndex--);
        }
    }

    public static int maxProfit1(int[] prices) {
        int useIndex = 0;
        boolean isRise = false;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1] > prices[i]){
                if (!isRise){
                    prices[useIndex] = prices[i];
                    useIndex++;
                }
                isRise = true;
            }else{
                if (isRise){
                    prices[useIndex] = prices[i];
                    useIndex++;
                }
                isRise = false;
            }
        }
        prices[useIndex] = prices[prices.length-1];

        int[] profit = new int[useIndex+1];
        for (int i = 0; i < useIndex+1; i++) {
            for (int j = i+1; j < useIndex+1; j++) {
                if (profit[i] < prices[j]-prices[i]) {
                    profit[i] = prices[j]-prices[i];
                }
            }
        }
        int maxProfit = 0;
        int index = 0;
        for (int i = 0; i < profit.length; i++) {
            if (maxProfit<profit[i]){
                maxProfit = profit[i];
                index = i;
            }
        }
        System.out.println(index);
        return maxProfit;
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] numsk = new int[k];
        for (int i = 0; i < k; i++) {

            int value = nums[i];
            int j = i;
            while (j < nums.length) {
                if (j+k>=nums.length){
                    j = j+k;
                    break;
                }
                int temp = nums[j+k];
                nums[j+k] = value;
                value = temp;
                j=j+k;
            }
            numsk[j-nums.length] = value;
        }
        for (int i = 0; i < k; i++) {
            nums[i] = numsk[i];
        }
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

    public static int removeElement(int[] nums, int val) {
        int count = 0 ,i=0;
        while(i+count<nums.length){
            if(nums[i+count] == val){
                count++;
            }else{
                nums[i] = nums[i+count];
                i++;
            }
            System.out.println(i);
            System.out.println(count);
        }
        return i;
    }

    public static int removeDuplicates(int[] nums) {
        int i=0,j=1;
        while(i+j<nums.length){
            if(nums[i] != nums[i+j]){
                i++;
            }else {
                j++;
            }
            if (i+j==nums.length){
                break;
            }
            nums[i+1] = nums[i+j];
        }
        return i+1;
    }

    public static int removeDuplicates2(int[] nums) {
        int i=0,j=1;
        boolean b = false;
        while(i+j<nums.length){
            if((nums[i] == nums[i+j]) && b){
                j++;
            }else if(nums[i] == nums[i+j]){
                b = true;
                i++;
                nums[i]=nums[i+j-1];
            }else{
                b = false;
                i++;
                nums[i]=nums[i+j-1];
            }
        }
        return i+1;//i是下标不是长度所以需要+1
    }

//    public static int majorityElement(int[] nums) {
//        int[] key = new int[nums.length/2];
//        int[] value = new int[nums.length/2];
//        for(int i=0;i<nums.length;i++){
//            key[nums[i]]++;
//        }
//        int maxCount = key[0];
//        int i = 0;
//        while (!(maxCount > nums.length/2)) {
//            maxCount = key[i];
//            i++;
//        }
//        System.out.println(Arrays.toString(key));
//        return i-1;
//    }

    public static int majorityElement(int[] nums) {
        KV[] kvs = new KV[nums.length];
        for (int i=0;i<nums.length;i++){
            for (int j = 0;j<nums.length;j++){
                if (kvs[j] ==null){
                    kvs[j] = new KV(nums[i],1);
                    break;
                }else{
                    if (kvs[j].key == nums[i]){
                        kvs[j].addOne();
                        if (kvs[j].value>nums.length/2){
                            return nums[i];
                        }
                        break;
                    }
                }
            }
        }
        return nums[nums.length/2];
    }

    static class KV{
        private int key;
        private int value;

        public KV(int key,int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return this.key==((KV)obj).key;
        }

        public void addOne() {
            this.value++;
        }
    }


}