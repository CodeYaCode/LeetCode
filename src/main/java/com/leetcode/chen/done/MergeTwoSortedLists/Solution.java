package com.leetcode.chen.done.MergeTwoSortedLists;

import lombok.extern.slf4j.Slf4j;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/8
 * Time: 9:03 am
 */
@Slf4j
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                // l2 all added or l1 < l2
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return head.next;
    }

    public static void show(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (null != cur) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.replace(sb.lastIndexOf("-"), sb.length() - 1, "");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(5);
        l2.next = l21;
        l21.next = l22;
        l22.next = l23;

        show(l1);
        show(l2);
        show(new Solution().mergeTwoLists(l1, l2));
    }
}
