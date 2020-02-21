package com.leetcode.chen.done.LinkedListCycleII;

/**
 * User: Chen Liu
 * Date: 2020/2/5
 * Time: 9:33 am
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return String.format("Value: %s", this.val);
    }
}
