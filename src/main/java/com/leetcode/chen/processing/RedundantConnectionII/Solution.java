package com.leetcode.chen.processing.RedundantConnectionII;

import java.util.*;

/**
 * https://leetcode.com/problems/redundant-connection-ii/
 *
 * User: Chen Liu
 * Date: 2020/2/2
 * Time: 9:48 pm
 */
public class Solution {
    public Map<Integer, List<Integer>> adjacency = new HashMap<>(16);

    public void buildAdjacency(int[][] edges) {
        for (int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            if (this.adjacency.containsKey(start)) {
                this.adjacency.get(start).add(end);
            } else {
                List<Integer> endPoints = new ArrayList<>();
                endPoints.add(end);
                this.adjacency.put(start, endPoints);
            }
        }
    }

    public void dfs(int point) {
        System.out.println(point);
        int index = 0;
        if (this.adjacency.containsKey(point)) {
            List<Integer> list = this.adjacency.get(point);
            while (index < list.size()) {
                int next = list.get(index);
                dfs(next);
                index++;
            }
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        this.buildAdjacency(edges);
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] e0 = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        int[][] e1 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[][] e2 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 5}, {5, 6}, {6, 9}, {5, 8}, {8, 10}};
        solution.buildAdjacency(e0);
        System.out.println(solution.adjacency);
        solution.dfs(1);
    }
}
