package com.leetcode.chen.ZigZagConversion;

import java.util.*;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author LiuChen
 * @date 2019/3/14
 */

public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        boolean down = true;
        int row = 0;
        String[] strings = s.split("");
        for (int i = 0; i < s.length(); i++) {
            // 字符
            String str = strings[i];
            StringBuilder sb = sbs[row];
            sb.append(str);
            if (down) {
                // 向下
                if (row == numRows - 1) {
                    // 底行，向上
                    down = false;
                    row--;
                    row = row < 0 ? 0 : row;
                } else {
                    row++;
                    row = row > numRows - 1 ? numRows - 1 : row;
                }
            } else {
                // 向上
                if (row == 0) {
                    // 顶行，向下
                    down = true;
                    row++;
                    row = row > numRows - 1 ? numRows - 1 : row;
                } else {
                    row--;
                    row = row < 0 ? 0 : row;
                }
            }
        }
        StringBuilder sb = sbs[0];
        for (int i = 1; i < numRows; i++) {
            sb.append(sbs[i].toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(16);
        map.put(3, "PAYPALISHIRING");
        map.put(4, "PAYPALISHIRING");
        map.put(1, "AB");
//        map.put(1, "ABC");

        map.forEach((numRows, str) ->
                System.out.println(String.format("String: %s, Convert: %s", str, new Solution().convert(str, numRows))));
    }
}
