package com.leetcode.chen.RegularExpressionMatching;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 * @author LiuChen
 * @date 2019/3/15
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        int result = 0, i = 0, j = 0;
        char[] sChars = s.toCharArray();
        int sLength = sChars.length;
        char[] pChars = p.toCharArray();
        int pLength = pChars.length;
        char lastChar = '\'';
        boolean dot;
        boolean star;
        while (i < sLength) {
            System.out.println(String.format("result: %s, s: %s", result, sChars[i]));
            result++;
            if (j == pLength) {
                break;
            }
            dot = pChars[j] == '.';
            star = pChars[j] == '*';
            if (dot) {
                result--;
                lastChar = pChars[j];
            } else if (star) {
                if (lastChar == sChars[i]) {
                    i++;
                    result--;
                } else {
                    j++;
                }
                continue;
            } else {
                sChars[i] = pChars[i];
                lastChar = sChars[i];
                result--;
            }
            i++;
            j++;
        }

        return result == 0;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(16);
//        map.put("aa", "a");
//        map.put("ab", ".*");
        map.put("aab", "c*a*b");
//        map.put("mississippi", "mis*is*p*.");

        map.forEach((s, p) -> System.out.println(String.format("s: %s\np: %s\nOutput: %s", s, p, new Solution().isMatch(s, p))));
    }
}
