package com.leetcode.chen.RomanToInteger;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiuChen
 * @date 2019/3/16
 */

public class Solution {
    private int getValue(char c) {
        if (c == 'I') {
            return 1;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'X') {
            return 10;
        }
        if (c == 'L') {
            return 50;
        }
        if (c == 'C') {
            return 100;
        }
        if (c == 'D') {
            return 500;
        }
        if (c == 'M') {
            return 1000;
        }
        return 0;
    }

    public int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int j = i + 1;
            int value = this.getValue(chars[i]);
            if (j < s.length()) {
                int value1 = this.getValue(chars[j]);
                if (value1 > value) {
                    result -= value;
                    result += value1;
                    i++;
                } else {
                    result += value;
                }
            } else {
                result += value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "III"
                , "IV"
                , "IX"
                , "LVIII"
                , "MCMXCIV"
        );
        list.forEach(input -> System.out.println(String.format("Input: %s, Output: %s", input, new Solution().romanToInt(input))));
    }
}
