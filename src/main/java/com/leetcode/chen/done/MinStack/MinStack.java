package com.leetcode.chen.done.MinStack;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/min-stack/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/12
 * Time: 9:10 am
 */
public class MinStack {
    /**
     * Store the elements
     */
    private int[] stack;

    /**
     * Stack's size
     */
    private int size;

    /**
     * Current position of top
     */
    private int pos;

    /**
     * Minimum number in the stack
     */
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new int[2];
        this.size = 0;
        this.pos = -1;
        this.min = 0;
    }

    public void push(int x) {
        this.stack[++this.pos] = x;
        this.size++;
        this.min = this.size == 1 || x < this.min ? x : this.min;
        if (this.stack.length == this.size) {
            // extension
            this.extendSize();
        }
    }

    public void pop() {
        if (this.min == this.stack[this.pos]) {
            this.min = this.stack[0];
            for (int i = 1; i < this.pos; i++) {
                if (this.stack[i] < this.min) {
                    this.min = this.stack[i];
                }
            }
        }
        this.pos--;
        this.size--;
    }

    public int top() {
        return this.stack[this.pos];
    }

    public int getMin() {
        return this.min;
    }

    private void extendSize() {
        this.stack = Arrays.copyOf(this.stack, this.size << 1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());   // Returns -3.
//        minStack.pop();
//        System.out.println(minStack.top());      // Returns 0.
//        System.out.println(minStack.getMin());   // Returns -2.

        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());      // Returns 2.
        minStack.pop();
        System.out.println(minStack.getMin());   // Returns 1.
        minStack.pop();
        System.out.println(minStack.getMin());   // Returns 1.
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());      // Returns 2.
        System.out.println(minStack.getMin());   // Returns 1.
        minStack.push(-2147483648);
        System.out.println(minStack.top());      // Returns 2.
        System.out.println(minStack.getMin());   // Returns 1.
        minStack.pop();
        System.out.println(minStack.getMin());   // Returns 1.
    }
}
