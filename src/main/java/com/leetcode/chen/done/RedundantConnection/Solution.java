package com.leetcode.chen.done.RedundantConnection;

/**
 * https://leetcode.com/problems/redundant-connection/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/2
 * Time: 7:10 pm
 */
class Solution {
    private int length;
    private int[] disjoint;
    private int[] treeSize;

    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        this.length = edges.length;
        this.disjoint = new int[this.length];
        this.treeSize = new int[this.length];
        for (int i = 0; i < this.length; i++) {
            this.disjoint[i] = i;
            this.treeSize[i] = 1;
        }
        for (int[] edge : edges) {
            int p = edge[0] - 1;
            int q = edge[1] - 1;
            if (find(p, q)) {
                result[0] = p + 1;
                result[1] = q + 1;
            } else {
                union(p, q);
            }
        }
        return result;
    }

    private void union(int p, int q) {
        int rootP = this.getRoot(p);
        int rootQ = this.getRoot(q);
        // weighted quick union
        if (this.treeSize[rootP] <= this.treeSize[rootQ]) {
            this.disjoint[rootP] = rootQ;
            this.treeSize[rootQ] += this.treeSize[rootP];
        } else {
            this.disjoint[rootQ] = rootP;
            this.treeSize[rootP] += this.treeSize[rootQ];
        }
    }

    private boolean find(int p, int q) {
        return this.getRoot(p) == this.getRoot(q);
    }

    private int getRoot(int p) {
        while (this.disjoint[p] != p) {
            // path compression
            this.disjoint[p] = this.disjoint[this.disjoint[p]];
            p = this.disjoint[p];
        }
        return p;
    }

    public static void show(int[] edge) {
        System.out.println("[" + edge[0] + ", " + edge[1] + "]");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] e0 = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        int[][] e1 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        show(solution.findRedundantConnection(e0));
        show(solution.findRedundantConnection(e1));
    }
}