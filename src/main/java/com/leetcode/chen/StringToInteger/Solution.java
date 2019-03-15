package com.leetcode.chen.StringToInteger;

import java.util.Arrays;
import java.util.List;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 *
 * @author LiuChen
 * @date 2019/3/14
 */

class Solution {
    private int parseInt(String str, boolean negative) {
        int result = 0, i = str.length() - 1;
        int co = negative ? -1 : 1;
        String[] numbers = str.split("");
        for (String n : numbers) {
            result += Math.pow(10, i) * Integer.valueOf(n) * co;
            if (negative) {
                if (result <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (result >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
            i--;
        }

        return result;
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int i = 0;
        boolean positive = chars[i] == '+';
        boolean negative = chars[i] == '-';
        if ((positive || negative) && str.length() == 1) {
            return 0;
        }
        i = (positive || negative) ? 1 : 0;
        boolean number = chars[i] >= '0' && chars[i] <= '9';
        if ((!positive || !negative) && !number) {
            // 不是数字,+-开头
            return 0;
        }
        int end = (positive || negative) ? 1 : 0;
        for (; end < chars.length; end++) {
            if (chars[end] < 48 || chars[end] > 57) {
                break;
            }
        }
        return this.parseInt(str.substring(i, end), negative);
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "+"
                , "42"
                , "-42"
                , "  -42"
                , "4193 with words"
                , "words and 987"
                , "-91283472332"
                , ""
                , "+-2"
                , "-+2"
                ,"-2147483647"
        );
        strings.forEach(string -> System.out.println(String.format("String: %s, Integer: %s", string, new Solution().myAtoi(string))));
    }
}
