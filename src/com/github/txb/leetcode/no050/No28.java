package com.github.txb.leetcode.no050;

/**
 * NO.28. Implement strStr()
 *
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * Created by tanghui on 2018/6/1.
 */
public class No28 {

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                // 已经达到 最后一位+1 且前面一直相等 满足条件
                if (j == needle.length())
                    return i;
                // 已经超出了 仍不相等
                if (i + j == haystack.length())
                    return -1;
                // 一旦出现不相等的字符，外层循环+1 重新开始查找数据
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
        }
    }

    public static void main(String[] args) {
        No28 no28 = new No28();

        String haystack1 = "hello", needle1 = "ll";
        String haystack2 = "aaaaa", needle2 = "bba";
        String haystack3 = "mississippi", needle3 = "mississippi";


        System.out.println(no28.strStr(haystack1, needle1));
        System.out.println(no28.strStr(haystack2, needle2));
        System.out.println(no28.strStr(haystack3, needle3));
    }

}
