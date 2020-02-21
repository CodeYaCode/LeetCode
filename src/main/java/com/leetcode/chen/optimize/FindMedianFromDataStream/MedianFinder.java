package com.leetcode.chen.optimize.FindMedianFromDataStream;

/**
 * User: Chen Liu
 * Date: 2020/2/19
 * Time: 9:27 am
 */
public class MedianFinder {
    class Node {
        double val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head;
    private Node median;
    private Node tail;
    private int length;

    /** initialize your data structure here. */
    public MedianFinder() {
        head = new Node(-1);
        median = null;
        tail = new Node(-1);
        length = 0;
    }

    public void addNum(int num) {
        Node newNode = new Node(num);
        if (null == head.next) {
            head.next = newNode;
            tail.next = newNode;
            median = newNode;
            length++;
        } else {
            // If num < median start from head, else start from median
            if (num < median.val) {
                Node cur = head;
                while (num > cur.next.val) {
                    cur = cur.next;
                }
                newNode.next = cur.next;
                cur.next.pre = newNode;
                cur.next = newNode;
                newNode.pre = cur;
                length++;
                if (length % 2 == 0) {
                    median = median.pre;
                }
            } else {
                Node cur = median;
                while (null != cur.next && num > cur.next.val) {
                    cur = cur.next;
                }
                newNode.next = cur.next;
                if (null != cur.next) {
                    cur.next.pre = newNode;
                }
                cur.next = newNode;
                newNode.pre = cur;
                length++;
                if (length % 2 != 0) {
                    median = median.next;
                }
            }
        }
    }

    public double findMedian() {
        if (0 == length) {
            return 0;
        }
        return length % 2 == 0 ? (median.val + median.next.val) / 2 : median.val;
    }

    public static void main(String[] args) {
//        ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(1);
//        medianFinder.addNum(2);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(3);
//        System.out.println(medianFinder.findMedian());
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(40);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(12);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(16);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(14);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(35);
        System.out.println(medianFinder.findMedian());
    }
}
