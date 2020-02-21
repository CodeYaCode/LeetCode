package com.leetcode.chen.util;

import com.leetcode.chen.processing.MergeKSortedLists.ListNode;

/**
 * User: Chen Liu
 * Date: 2020/2/9
 * Time: 12:45 pm
 */
public class NodeListUtil {
    public static void show(ListNode head) {
        if (null == head) {
            System.out.println("[]");
            return;
        }
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (null != cur) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.replace(sb.lastIndexOf("-"), sb.length() - 1, "");
        System.out.println(sb.toString());
    }
}
