package com.leetcode.chen.IntegerToRoman;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiuChen
 * @date 2019/3/16
 */

public class Solution {
    private String getValue(int num) {
        if (num == 0) {
            return "I";
        }
        if (num == 1) {
            return "V";
        }
        if (num == 2) {
            return "X";
        }
        if (num == 3) {
            return "L";
        }
        if (num == 4) {
            return "C";
        }
        if (num == 5) {
            return "D";
        }
        if (num == 6) {
            return "M";
        }

        return "";
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int remainder = num % 10;
            String value = this.getValue(i);
            for (;remainder > 0;remainder--) {
                sb.append(value);
            }
            i++;

            num /= 10;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(
                3
                , 4
                , 9
                , 58
                , 1994
        );
        list.forEach(input -> System.out.println(String.format("Input: %s, Output: %s", input, new Solution().intToRoman(input))));
    }
}
