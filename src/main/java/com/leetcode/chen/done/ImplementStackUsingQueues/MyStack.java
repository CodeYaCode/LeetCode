package com.leetcode.chen.done.ImplementStackUsingQueues;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/10
 * Time: 9:11 am
 */
public class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    /**
     * Current queue
     */
    private Queue<Integer> cur;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.q1 = new ConcurrentLinkedQueue<>();
        this.q2 = new ConcurrentLinkedQueue<>();
        this.cur = q1;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        this.cur.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Queue<Integer> target = this.cur == this.q1 ? this.q2 : this.q1;
        int size = this.cur.size();
        for (int i = 0; i < size - 1; i++) {
            target.add(this.cur.poll());
        }
        int res = this.cur.poll().intValue();
        this.cur = target;

        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        Queue<Integer> target = this.cur == this.q1 ? this.q2 : this.q1;
        int size = this.cur.size();
        for (int i = 0; i < size - 1; i++) {
            target.add(this.cur.poll());
        }
        int res = this.cur.peek().intValue();
        target.add(this.cur.poll());
        this.cur = target;

        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.cur.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
    }
}
