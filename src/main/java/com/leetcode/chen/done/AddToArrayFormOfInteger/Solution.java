package com.leetcode.chen.done.AddToArrayFormOfInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Chen Liu
 * Date: 2020/2/18
 * Time: 9:48 am
 */
class Solution {
    public List<Integer> addToArrayForm(int[] A, int k) {
        int remainer = k % 10;
        k /= 10;
        int i = A.length - 1;
        int j = 0;
        while ((k > 0 || remainer != 0) || j == 1) {
            A[i] += remainer + j;
            j = 0;
            if (A[i] >= 10) {
                A[i] = A[i] - 10;
                j = 1;
            }
            i--;
            if (i < 0) {
                break;
            }
            remainer = k % 10;
            k /= 10;
        }
        List<Integer> list = new ArrayList<>();
        if (j != 0) {
            k += j;
        }
        List<Integer> temp = new ArrayList<>();
        while (k > 0) {
            remainer = k % 10;
            k /= 10;
            temp.add(remainer);
        }
        for (i = temp.size() - 1; i >= 0; i--) {
            list.add(temp.get(i));
        }
        for (int a : A) {
            list.add(a);
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] A = {1,2,0,0};
//        int k = 34;
//        int[] A = {2,1,5};
//        int k = 8060;
        int[] A = {0};
        int k = 10000;
        System.out.println(new Solution().addToArrayForm(A, k));
    }
}