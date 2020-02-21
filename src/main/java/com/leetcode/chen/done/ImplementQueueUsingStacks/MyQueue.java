package com.leetcode.chen.done.ImplementQueueUsingStacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * User: Chen Liu
 * Date: 2020/2/11
 * Time: 3:12 pm
 */
public class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
    /**
     * True for out
     * False for in
     */
    private boolean isOut;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
        this.isOut = true;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (this.isOut) {
            this.reform();
        }
        this.in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!this.isOut) {
            this.reform();
        }
        return this.out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!this.isOut) {
            this.reform();
        }
        return this.out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.in.isEmpty() && this.out.isEmpty();
    }

    private void reform() {
        Stack<Integer> origin = this.isOut ? this.out : this.in;
        Stack<Integer> target = this.isOut ? this.in : this.out;
        while (!origin.isEmpty()) {
            target.push(origin.pop());
        }
        this.isOut = !this.isOut;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }
}
