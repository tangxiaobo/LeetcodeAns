package com.github.txb.leetcode.no100;

/**
 * NO.58. Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 * Input: "Hello World"
 * Output: 5
 *
 * Created by tanghui on 2018/6/12.
 */
public class No58 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - (s.lastIndexOf(' ') + 1);
    }

    public static void main(String[] args) {
        No58 no58 = new No58();
        String s = "Hello World";
        System.out.println(no58.lengthOfLastWord(s));
    }
}
