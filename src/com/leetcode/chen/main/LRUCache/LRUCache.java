/*
 * $Header: Solution.java
 * $Revision: 1.0.0.0
 * $CreateDate: 2018年3月21日
 * $ModifyDate: 2018年3月21日
 * $Owner: LiuChen
 * 
 * Copyright (c) 2017-2027 ShangHai ChenJxx Co. Ltd.
 * All Right Reserved.
 */
package com.leetcode.chen.main.LRUCache;

import java.util.Hashtable;

/**
 * Solution.java
 * @author LiuChen
 * @version 1.0.0.0 2018年3月21日
 */
class LRUCache {
    private int capacity;
    Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
    
    private class Node {
        Node pre;
        Node next;
        
    }

    public LRUCache(int capacity) {
        
    }
    
    public int get(int key) {
        return table.get(key);
    }
    
    public void put(int key, int value) {
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */