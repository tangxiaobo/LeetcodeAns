package com.github.txb.leetcode.no050;

import java.util.HashSet;
import java.util.Set;

/**
 * NO.3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Created by tanghui on 2018/2/4.
 */
public class No3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, maxLen = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j - i); // 上面已经有 j++ 了，此处不用再 +1
            } else {
                set.remove(s.charAt(i++)); // 此处 按顺序从前面一直删除字符，直到 set 中的字符不再含有与j处的字符相重复
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        No3 no3 = new No3();

        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println(no3.lengthOfLongestSubstring(s1));
        System.out.println(no3.lengthOfLongestSubstring(s2));
        System.out.println(no3.lengthOfLongestSubstring(s3));
    }
}
