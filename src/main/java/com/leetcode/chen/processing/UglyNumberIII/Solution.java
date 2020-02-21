package com.leetcode.chen.processing.UglyNumberIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/ugly-number-iii/
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive integers which are divisible by a or b or c.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * Example 2:
 *
 * Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
 * Example 3:
 *
 * Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
 * Example 4:
 *
 * Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
 * Output: 1999999984
 *
 *
 * Constraints:
 *
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * It's guaranteed that the result will be in range [1, 2 * 10^9]
 *
 * User: Chen Liu
 * Date: 2020/1/20
 * Time: 9:56 pm
 */
public class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        // Sort a b c
        List<Integer> sorted = this.sort(a, b, c);
        a = sorted.get(0);
        b = sorted.get(1);
        c = sorted.get(2);
        int aMax = a * n;
        int bMax = 0;
        // Guess the num equals to aMax
        int num = aMax;
        for (int i = b; i <= aMax; i += b) {
            // Check [b, aMax] whether has the ugly number
            // which can be divisible by b
            if (i == b && b % a == 0) {
                continue;
            }
            if (i % b == 0 && i % a != 0) {
                // Different ugly number
                aMax -= a;
                bMax = i;
                num = Math.max(aMax, bMax);
                System.out.println("B: Last " + num + " AMax: " + aMax + " BMax: " + bMax);
            }
        }
        for (int i = c; i <= num; i += c) {
            // Check [c, num] whether has the ugly number
            // which can be divisible by c
            if (i == c && (c % a == 0 || c % b == 0)) {
                continue;
            }
            if (i % c == 0 && i % b != 0 && i % a != 0) {
                // Different ugly number
                if (aMax > bMax) {
                    // Last num is aMax
                    System.out.println("Remove: " + aMax);
                    aMax -= a;
                } else {
                    // Last num is bMax
                    System.out.println("Remove: " + bMax);
                    bMax -= b;
                }
                num = Math.max(aMax, bMax);
                num = Math.max(num, i);
            }
        }
        return num;
    }

    /**
     * Sort a b c
     * @param a a
     * @param b b
     * @param c c
     * @return Sorted array
     */
    private List<Integer> sort(int a, int b, int c) {
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().nthUglyNumber(3, 2, 3, 5)); // 4
//        System.out.println(new Solution().nthUglyNumber(4, 2, 3, 4)); // 6
//        System.out.println(new Solution().nthUglyNumber(5, 2, 11, 13)); // 10
//        System.out.println(new Solution().nthUglyNumber(1000000000, 2, 217983653, 336916467));
//        System.out.println(new Solution().nthUglyNumber(8, 5, 7, 3)); // 14
//        System.out.println(new Solution().nthUglyNumber(9, 5, 9, 8)); // 24
//        System.out.println(new Solution().nthUglyNumber(10, 7, 6, 8)); // 28
        System.out.println(new Solution().nthUglyNumber(100, 36, 65, 59)); // 1690
    }
}