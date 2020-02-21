package com.leetcode.chen.processing.MergeKSortedLists;

import com.leetcode.chen.util.NodeListUtil;

import java.util.Arrays;

/**
 * User: Chen Liu
 * Date: 2020/2/9
 * Time: 12:35 pm
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length);
    }

    private ListNode mergeKLists(ListNode[] listNodes, int start, int end) {
        if (start >= end) {
            return null;
        }
        if (end - start == 1) {
            return listNodes[start];
        }
        int mid = (start + end) / 2;
        ListNode left = mergeKLists(listNodes, start, mid);
        ListNode right = mergeKLists(listNodes, mid, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        cur.next = l1 != null ? l1 : l2;
        return head.next;
    }

    public static ListNode[] parseList(String input) {
        String[] lists = input.replace("\n", "").replace(" ", "").split(",");
        ListNode[] listNodes = new ListNode[lists.length];
        int i = 0;
        for (String list : lists) {
            String[] values = list.split("->");
            ListNode head = new ListNode(Integer.parseInt(values[0]));
            ListNode cur = head;
            listNodes[i] = head;
            i++;
            for (int j = 1; j < values.length; j++) {
                cur.next = new ListNode(Integer.parseInt(values[j]));
                cur = cur.next;
            }
        }

        return listNodes;
    }

    public static void main(String[] args) {
        String input = "1->4->5,\n" +
                "  1->3->4,\n" +
                "  2->6";
        ListNode[] listNodes = parseList(input);
        NodeListUtil.show(new Solution().mergeKLists(listNodes));
    }
}
