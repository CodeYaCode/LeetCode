package com.leetcode.chen.LongestCommonPrefix;

/**
 * @author LiuChen
 * @date 2019/3/20
 */

public class Solution {
    private String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int longestLength = strs[0].length();
        char[] chars = new char[longestLength];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] cs = str.toCharArray();
            if (i == 0) {
                chars = cs;
            } else {
                for (int j = 0; j < longestLength; j++) {
                    if (cs.length - 1 < j || chars[j] != cs[j]) {
                        longestLength = j;
                        break;
                    }
                }
            }
        }

        return strs[0].substring(0, longestLength);
    }

    public static void main(String[] args) {
//        String[] strings = new String[]{"flower","flow","flight"};
//        String[] strings = new String[]{"flower","flow","floight"};
//        String[] strings = new String[]{"dog","racecar","car"};
        String[] strings = new String[]{"aa","a"};

        System.out.println(String.format("Input: %s, Output: %s", arrayToString(strings), new Solution().longestCommonPrefix(strings)));
    }

    private static String arrayToString(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str).append(",");
        }
        return "[" + sb.toString().substring(0, sb.length() - 1) + "]";
    }
}
