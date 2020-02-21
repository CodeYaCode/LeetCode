package com.leetcode.chen.done.UniquePaths;

import lombok.extern.slf4j.Slf4j;

/**
 * https://leetcode.com/problems/unique-paths/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/3
 * Time: 7:35 pm
 */
@Slf4j
public class Solution {

    public int uniquePaths(int m, int n) {
        int[][] grids = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    grids[i][j] = 1;
                } else {
                    grids[i][j] = grids[i + 1][j] + grids[i][j + 1];
                }
            }
        }

        return grids[0][0];
    }

    // 递归算法，Time limited exceeded
//    private int m, n;
//    private int output;
//    private void findPath(int col, int row) {
//        if (col == this.m - 1 && row == this.n - 1) {
//            // find one path
//            this.output++;
//            return;
//        }
//        if (col < this.m - 1) {
//            // Not right-most
////            log.info("Move to ({}, {})", col + 1 + 1, row + 1);
//            // Move to right
//            findPath(col + 1, row);
//        }
//        if (row < this.n - 1) {
//            // Not bottom-most
////            log.info("Move to ({}, {})", col + 1, row + 1 + 1);
//            // Move to bottom
//            findPath(col, row + 1);
//        }
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 2));
        System.out.println(solution.uniquePaths(7, 3));
        System.out.println(solution.uniquePaths(51, 9));
        System.out.println(solution.uniquePaths(5, 4));
    }
}
