package com.leetcode.chen.LongestPalindromicSubstring;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiuChen
 * @Title Longest palindromic substring
 * @Description Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * @Example Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 * @date 2019/3/14
 */

public class Manacher {
    private String formatString(String s) {
        String[] strs = s.split("");
        String newStrs = "$#";
        for (int i = 0; i < strs.length; i++) {
            newStrs += strs[i];
            newStrs += "#";
        }
        return newStrs;
    }

    /**
     * 计算回文串的长度
     *
     * @param strs strs
     * @param id   id
     * @return int
     */
    private int len(String[] strs, int id) {
        int i = id, j = id, len = 1;
        while (j > 0 && i < strs.length - 1) {
            if (strs[--j].equals(strs[++i])) {
                len++;
            } else {
                break;
            }
        }
        return len;
    }

    public String longestPalindrome(String s) {
        String formatString = formatString(s);
        String[] strs = formatString.split("");
        int length = strs.length;
        int p0 = 1;
        int max = 1;
        int[] len = new int[length + 1];
        for (int id = 1; id < length; id++) {
            if (id >= max) {
                // 需要重新计算
                len[id] = this.len(strs, id);
                if (len[p0] < len[id]) {
                    // 更长
                    p0 = id;
                    max = id + len[id] - 1;
                }
            } else {
                int j = 2 * p0 - id;
                int pmax = 2 * p0 - max;
                if (j - pmax <= len[j]) {
                    // id需要向右拓展
                    len[id] = len(strs, id);
                    if (len[p0] < len[id]) {
                        // 更长
                        p0 = id;
                        max = id + len[id] - 1;
                    }
                } else {
                    len[id] = len[j];
                }
            }
        }
        return formatString.substring(2 * p0 - max, max + 1).replace("#", "");
    }

    public String longestPalindrome1(String s) {
        // dp
        if (s.length() == 0) return "";

        int maxStart = 0;
        int maxEnd = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];

        //making everything below the diagonal as true
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = true;
            }
        }

        int maxLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;   //diagonal as true
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (maxLength < j - i) {
                        maxLength = j - i;
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "ccc"
                , "babad"
                , "cbbd"
                , "abcba"
                , "babadada"
        );
        strings.forEach(strs -> {
            String max = new Manacher().longestPalindrome1(strs);
            System.out.println(String.format("strs: %s, longest: %s", strs, max));
        });
    }
}
