/**
 * Longest substring without repeating characters
 */
package com.leetcode.chen.main.LongestSubstringWithoutRepeatingCharacters;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title Longest substring without repeating characters
 * @Description
 *  Given a string, find the length of the longest substring without repeating characters.
 * @Example
 *  Given "abcabcbb", the answer is "abc", which the length is 3.
 *  Given "bbbbb", the answer is "b", with the length of 1.
 *  Given "pwwkew", the answer is "wke", with the length of 3. 
 *  Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author LiuChen
 *
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuffer container = new StringBuffer();
        String[] strs = s.trim().split("");
        int length = 0;
        for(int i=0; i<strs.length; i++) {
            if(container.indexOf(strs[i]) != -1) { // repeating character.
                length = container.length() > length ? container.length() : length; // record max length.
                container = container.delete(0, container.indexOf(strs[i]) + 1);
            }
            container.append(strs[i]);
        }
        return length > container.length() ? length : container.length();
    }
    
    public static void main(String[] args) {
        String str = "abcabcbb";
        String str1= "bbbbb";
        String str2= "pwwkew";
        String str3= "";
        System.out.println(new Solution().lengthOfLongestSubstring(str));
        System.out.println(new Solution().lengthOfLongestSubstring(str1));
        System.out.println(new Solution().lengthOfLongestSubstring(str2));
        System.out.println(new Solution().lengthOfLongestSubstring(str3));
        
        long a = 10;a*=1000L;
        System.out.println(a);
    }
}
