/**
 * Median of two sorted arrays
 */
package com.leetcode.chen.MedianOfTwoSortedArrays;

/**
 * @Title Median of two sorted arrays
 * @Description
 *  There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *  Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @Example
 *  Example 1:
 *      nums1 = [1, 3]
 *      nums2 = [2]
 *
 *      The median is 2.0
 *  Example 2:
 *      nums1 = [1, 2]
 *      nums2 = [3, 4]
 *
 *      The median is (2 + 3)/2 = 2.5
 * @author LiuChen
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, t = 0, ans = 0;
        if((m+n) % 2 == 0) {
            int ans2 = 0;
            while(t <= (m+n)/2) {
                if(i >= m && j < n) {
                    ans2 = ans;
                    ans = nums2[j];
                    j++;
                } else if(j >= n && i < m) {
                    ans2 = ans;
                    ans = nums1[i];
                    i++;
                }else if(nums1[i] < nums2[j]) {
                    ans2 = ans;
                    ans = nums1[i];
                    i++;
                } else {
                    ans2 = ans;
                    ans = nums2[j];
                    j++;
                }
                t++;
            }
            return (ans + ans2)/2.0;
        } else {
            while(t <= (m+n)/2) {
                if(i >= m && j < n) {
                    ans = nums2[j];
                    j++;
                } else if(j >= n && i < m) {
                    ans = nums1[i];
                    i++;
                }else if(nums1[i] < nums2[j]) {
                    ans = nums1[i];
                    i++;
                } else {
                    ans = nums2[j];
                    j++;
                }
                t++;
            }
            return ans;
        }
    }
}
