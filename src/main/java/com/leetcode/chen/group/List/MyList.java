package com.leetcode.chen.group.List;

/**
 * User: Chen Liu
 * Date: 2020/2/4
 * Time: 10:27 am
 */
public class MyList {
    private Node head;

    private int length;

    /**
     * Constructor
     *
     * @param values values
     */
    public MyList(int... values) {
        if (null != values) {
            head = new Node();
            Node current = head;
            for (int i = 0; i < values.length; i++) {
                current.next = new Node(values[i]);
                this.length++;
                current = current.next;
            }
        }
    }

    /**
     * Reverse from m to n
     *
     * @param m m
     * @param n n
     */
    public void reverse(int m, int n) {
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        if (min <= 0 || min > this.length || max > this.length) {
            System.err.println("Illegal parameters.");
            return;
        }
        if (this.length == 1) {
            return;
        }
        Node previous = this.head;
        Node current = previous.next;
        Node next = current.next;
        Node first = null;
        int i = 0;
        while (i < max) {
            if (i == min - 1) {
                first = current;
            }
            if (i >= min - 1) {
                // Between min -> max
                current.next = previous;
                previous = current;
                current = next;
                if (null != next) {
                    next = next.next;
                }
            } else {
                // index < min
                previous = current;
                current = current.next;
                next = current.next;
            }
            i++;
        }
        first.next.next = previous;
        first.next = current;
    }

    public void show() {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (null != current.next) {
            current = current.next;
            sb.append(current.value)
                    .append(" -> ");
        }
        sb.replace(sb.lastIndexOf("-"), sb.length(), "-> NULL");
        System.out.println(sb.toString());
    }

    private class Node {
        public int value;
        public Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
//        MyList list = new MyList(1, 2, 3, 4, 5, 6, 7, 8);
        MyList list = new MyList(1, 2, 3, 4, 5);
//        MyList list = new MyList(1, 2);
        list.show();
        list.reverse(2, 4);
        list.show();
    }
}
