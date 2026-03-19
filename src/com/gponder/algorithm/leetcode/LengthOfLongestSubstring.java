package com.gponder.algorithm.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author
 * @date 2024/12/23 17:41
 * @version V1.0
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String sb = "";
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            int index = sb.indexOf(c);
            if (index != -1) {
                sb = sb.substring(index+1);
            }
            sb+=c;
            if (max<sb.length()){
                max = sb.length();
            }
        }
        return max;
    }
}
