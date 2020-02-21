/**
 * ArrayPartitionI.java
 */
package com.leetcode.chen.done.ArrayPartitionI;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 * 
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4.
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 * 
 * @author LiuChen
 *
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i=0; i<nums.length; i+=2) {
            result += nums[i];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] nums = {1, 4, 3, 2,213,3213,3,213,23,469776,636,1239,6,900,12};
        int[] nums = {3, 2, 1, 4};
        
        System.out.println(s.arrayPairSum(nums));
    }
}
