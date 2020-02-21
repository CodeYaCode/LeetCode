package com.leetcode.chen.done.FindAndReplacePattern;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/4
 * Time: 7:28 pm
 */
@Slf4j
public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (this.equalsInPattern(word, pattern)) {
                list.add(word);
            }
        }
        return list;
    }

    public boolean equalsInPattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        int length = pattern.length();
        Map<Character, Integer> wordMap = new HashMap<>(length);
        Map<Character, Integer> patternMap = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            char wordChar = word.charAt(i);
            char patternChar = pattern.charAt(i);
            Integer wordIndex = wordMap.get(word.charAt(i));
            Integer patternIndex = patternMap.get(pattern.charAt(i));
            if (null == wordIndex) {
                // Not add yet
                wordIndex = wordMap.size();
                wordMap.put(wordChar, wordIndex);
            }
            if (null == patternIndex) {
                // Not put yet
                patternIndex = patternMap.size();
                patternMap.put(patternChar, patternIndex);
            }
            if (!patternIndex.equals(wordIndex)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words0 = new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern0 = "abb";
        String[] words1 = new String[]{"qqcojjumwp", "mqidrqudxu", "xwrvnueult", "lubbymxyro", "fcvxuskhcl"};
        String pattern1 = "rdzkpkbmda";
        log.info("{}", new Solution().findAndReplacePattern(words1, pattern1));
    }
}
