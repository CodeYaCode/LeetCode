package com.leetcode.chen.PalindromeNumber;

import java.util.Arrays;
import java.util.List;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * @author LiuChen
 * @date 2019/3/15
 */

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] str = String.valueOf(x).toCharArray();
        for (int i = 0; i < str.length / 2; i++) {
            if (str[i] != str[str.length - 1 -i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(
                121
                ,-121
                ,10
                ,1001
                ,1239321
        );
        list.forEach(i -> System.out.println(String.format("Input: %s, Output: %s", i, new Solution().isPalindrome(i))));
    }
}
