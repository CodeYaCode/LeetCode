package com.leetcode.chen.done.AssignCookies;

import java.util.Arrays;

/**
 * User: Chen Liu
 * Date: 2020/2/20
 * Time: 9:00 pm
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int res = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                res++;
            }
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] g = {1, 2, 3};
//        int[] s = {1, 1};
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(new Solution().findContentChildren(g, s));
    }
}
