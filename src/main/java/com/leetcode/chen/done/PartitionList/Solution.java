package com.leetcode.chen.done.PartitionList;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-list/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/6
 * Time: 9:45 am
 */
@Slf4j
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        ListNode less = newHead;
        while (null != cur && null != cur.next) {
            if (cur.next.val < x) {
                ListNode temp = cur.next;
                if (less.next != cur.next) {
                    cur.next = temp.next;
                    temp.next = less.next;
                    less.next = temp;
                } else {
                    cur = cur.next;
                }
                less = temp;
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    public static List<Integer> parseInts(String str) {
        List<Integer> list = new ArrayList<>();
        for (String s : str.split("")) {
            try {
                int i = Integer.parseInt(s);
                list.add(i);
            } catch (NumberFormatException ex) {

            }
        }
        return list;
    }

    public static void show(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (null != cur) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.replace(sb.lastIndexOf("-"), sb.length() -1 , "");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
//        String l = "head = 1->4->3->2->5->2, x = 3";
//        String l = "head = 2->1, x = 2";
        String l = "head = 3->1->2, x = 3";
//        String l = "head = 1->4->6->2->5->3, x = 4";
        List<Integer> params = parseInts(l);
        int x = params.get(params.size() - 1);
        ListNode head = new ListNode(params.get(0));
        ListNode temp = head;
        for (int i = 1; i < params.size() - 1; i++) {
            temp.next = new ListNode(params.get(i));
            temp = temp.next;
        }
        show(head);
        ListNode node = new Solution().partition(head, x);
        show(node);
    }
}
