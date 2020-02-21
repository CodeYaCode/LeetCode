/*
 * Add two numbers
 */
package com.leetcode.chen.done.AddTwoNumbers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Title Add Two Numbers
 * @Desctiption
 *  You are given two non-empty linked lists representing two non-negative integers. 
 *  The digits are stored in reverse order and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.
 *  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * @Example
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 * @author LiuChen
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode head = null, tail = null;
        head = tail = new ListNode(0);
        int flag = 0, sum = 0;
        while (null != p1 || null != p2) {
            sum = (null == p1 ? 0 : p1.val) + (null == p2 ? 0 : p2.val) + flag;
            flag = sum / 10;
            sum = sum % 10;
            tail = tail.next = new ListNode(sum);
            p1 = (null == p1 ? null : p1.next);
            p2 = (null == p2 ? null : p2.next);
        }
        if (flag == 1) {
            tail.next = new ListNode(1);
        }
        
        return head.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);
        l4.next = new ListNode(9);
        
        System.out.println(new Solution().addTwoNumbers(l1, l2));        
        System.out.println(new Solution().addTwoNumbers(l3, l4));
    }
}