package com.leetcode.chen.done.LinkedListCycleII;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/5
 * Time: 9:24 am
 */
@Slf4j
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>(16);
        while (null != head) {
            if (map.containsKey(head)) {
                return head;
            }
            map.put(head, head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                // there is a cycle, find the start of the loop
                while (head != tortoise) {
                    head = head.next;
                    tortoise = tortoise.next;
                }
                return head;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1000);
        ListNode node0 = new ListNode(0);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(-4);
        head.next = node3;
        node3.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;
        log.info("{}", new Solution().detectCycle(head).val == new Solution().detectCycle1(head).val);
    }
}
