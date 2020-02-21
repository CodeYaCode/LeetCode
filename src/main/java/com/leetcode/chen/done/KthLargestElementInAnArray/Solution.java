package com.leetcode.chen.done.KthLargestElementInAnArray;

import java.util.Arrays;

/**
 * User: Chen Liu
 * Date: 2020/2/18
 * Time: 9:05 am
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int kth = 1;
        int i = nums.length - 1;
        int re = nums[i];
        while (kth != k) {
            i--;
            re = nums[i];
            kth++;
        }
        return re;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
//        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
//        int k = 4;
        System.out.println(new Solution().findKthLargest(nums, k));
    }
}
