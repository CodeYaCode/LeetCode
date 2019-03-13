/*
 * $Header: Solution.java
 * $Revision: 1.0.0.0
 * $CreateDate: 2018年3月20日
 * $ModifyDate: 2018年3月20日
 * $Owner: LiuChen
 * 
 * Copyright (c) 2017-2027 ShangHai ChenJxx Co. Ltd.
 * All Right Reserved.
 */
package com.leetcode.chen.ReverseInteger;

/**
 * Solution.java
 * 
 * @author LiuChen
 * @version 1.0.0.0 2018年3月20日
 */
public class Solution {

    public static void main(String[] args) {
        int x = 123;
        Solution solution = new Solution();
        int result = solution.reverse(x);
        System.out.println(result);
    }

    public int reverse(int x) {
        int r = 0, result = 0, temp = 0;
        int positive = x>=0 ? 1:-1;
        x = Math.abs(x);
        while (x > 0) {
            r = x % 10;
            x /= 10;
            temp = result * 10;
            if (temp / 10 != result) {
                return 0;
            }
            result = temp + r;
        }
        return positive * result;
    }
}
