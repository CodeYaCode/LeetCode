package com.leetcode.chen.done.BasicCalculator;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/13
 * Time: 10:59 am
 */
public class Solution {
    private Stack<Object> stack = new Stack<>();
    public int calculate(String s) {
        char[] chars = s.replace(" ", "").toCharArray();
        for (int i = chars.length - 1; i >= 0;) {
            char c = chars[i];
            if (isNum(c)) {
                int num = 0;
                int n = 0;
                while (i >= 0 && isNum(chars[i])) {
                    num += (int) Math.pow(10, n++) * (chars[i--] - '0');
                }
                stack.push(num);
            } else if('(' == c) {
                int res = eval();
                stack.pop();
                stack.push(res);
                i--;
            } else {
                stack.push(c);
                i--;
            }
        }

        return eval();
    }

    private int eval() {
        int res = 0;
        if (!stack.empty()) {
            res = (int) stack.pop();
        }
        while (!stack.empty() && !((char) stack.peek() == ')')) {
            char operation = (char) stack.pop();
            int right = (int) stack.pop();
            if ('+' == operation) {
                res += right;
            } else if ('-' == operation) {
                res -= right;
            }
        }

        return res;
    }

    private boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }

    public static void main(String[] args) {
        String input = "1 + 1";
//        System.out.println(new Solution().calculate(input));
        String input1 = "2-1 + 2";
//        System.out.println(new Solution().calculate(input1));
        String input2 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new Solution().calculate(input2));
        String input3 = "2-(5-6)";
        System.out.println(new Solution().calculate(input3));
        String input4 = "123";
        System.out.println(new Solution().calculate(input4));
        String input5 = "(7)-(0)+(4)";
        System.out.println(new Solution().calculate(input5));
    }
}
