package com.leetcode.chen.done.CopyListWithRandomPointer;

/**
 * User: Chen Liu
 * Date: 2020/2/7
 * Time: 11:58 am
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
