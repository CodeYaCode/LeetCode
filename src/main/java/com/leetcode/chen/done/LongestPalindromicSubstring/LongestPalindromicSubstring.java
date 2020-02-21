/**
 * Longest palindromic substring
 */
package com.leetcode.chen.done.LongestPalindromicSubstring;

/**
 * @Title Longest palindromic substring
 * @Description
 *  Given a string s, find the longest palindromic substring in s. 
 *  You may assume that the maximum length of s is 1000.
 * @Example
 * 
 *  Example:
 *  Input: "babad"
 *  Output: "bab"
 *  Note: "aba" is also a valid answer.
 *  
 *  Example:
 *  Input: "cbbd"
 *  Output: "bb"
 * @author LiuChen
 *
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int max = 0, start = 0, length = s.length();
        String ans = s;
        while(max < ans.length()) {
            if (isPalindrome(ans)) {
                max = ans.length();
                break;
            }
            ans = s.substring(start, --length);
        }
        return ans;
    }
    
    public boolean isPalindrome(String s) {
        if (null == s || 1 <= s.length()) {
            return true;
        }
        if (2 == s.length()) {
            if (s.substring(0, 1).equals(s.substring(1))) {
                return true;
            }
            return false;
        }
        if (3 == s.length()) {
            if (s.substring(0, 1).equals(s.substring(2))) {
                return true;
            }
            return false;
        }
        if (s.substring(0, 1).equals(s.substring(s.length()-1, s.length()))) {
            return isPalindrome(s.substring(1, s.length()-1));
        }
        return false;
    }
    
    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(s.length()-1, s.length()));
        System.out.println(l.longestPalindrome(s));
        System.out.println(l.isPalindrome(s));
    }
}
