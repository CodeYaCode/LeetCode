/*
 * Two Sum
 */
package com.leetcode.chen.done.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title Two Sum
 * @Description
 *  Given an array of integers, return indices of the two numbers 
 *  such that they add up to a specific target.
 *  You may assume that each input would have exactly one solution, 
 *  and you may not use the same element twice.
 * @Example
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 * 
 * @author LiuChen
 */
public class Solution {
    public int[] twoSum (int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (maps.containsKey(n)) {
                return new int[]{i, maps.get(n)};
            }
            maps.put(nums[i], i);
        }
        return null;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        long start = System.currentTimeMillis();
        int[] result = new Solution().twoSum(nums, target);
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println("spend:" + (end-start));
    }
}