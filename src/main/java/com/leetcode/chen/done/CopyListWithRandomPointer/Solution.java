package com.leetcode.chen.done.CopyListWithRandomPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Chen Liu
 * Date: 2020/2/7
 * Time: 11:58 am
 */
@Slf4j
public class Solution {
    private Map<Node, Node> old2NewNodeMap = new HashMap<>(16);

    public Node copyRandomList(Node head) {
        Node newHead = new Node(0);
        Node newCur = newHead;
        Node oldCur = head;
        while (null != oldCur) {
            Node oldNext = oldCur.next;
            Node oldRandom = oldCur.random;
            newCur.next = this.getOrCreateNew(oldCur);
            if (null != oldNext) {
                newCur.next.next = this.getOrCreateNew(oldCur.next);
            }
            if (null != oldRandom) {
                newCur.next.random = this.getOrCreateNew(oldCur.random);
            }
            oldCur = oldCur.next;
            newCur = newCur.next;
        }

        return newHead.next;
    }

    /**
     * Get a node, if not exist, create a new node
     *
     * @param keyNode node from origin list
     * @return new node
     */
    private Node getOrCreateNew(Node keyNode) {
        Node newNode;
        if (old2NewNodeMap.containsKey(keyNode)) {
            // New node has already created
            newNode = old2NewNodeMap.get(keyNode);
        } else {
            newNode = new Node(keyNode.val);
            old2NewNodeMap.put(keyNode, newNode);
        }
        return newNode;
    }

    public static void show(Node head) {
        Node cur = head;
        StringBuilder sb = new StringBuilder();
        while (null != cur) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.replace(sb.lastIndexOf("-"), sb.length() -1 , "");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String input = "[[7,null],[13,0],[11,4],[10,2],[1,0]]";
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = null;
        node1.random = head;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;

        show(head);
        show(new Solution().copyRandomList(head));
    }
}
