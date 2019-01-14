package com.github.txb.leetcode.no200;

/**
 * NO.171. Excel Sheet Column Number
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * Example 1:
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 * Input: "AB"
 * Output: 28
 *
 * Example 3:
 * Input: "ZY"
 * Output: 701
 *
 * Created by tanghui on 2018/6/12.
 */
public class No171 {

    public int titleToNumber(String s) {
        int n = 0;
        // 26进制 边10进制
        for (int i = 0; i < s.length(); i++) {
            n *= 26;
            n += s.charAt(i) - 'A' + 1;
        }

        return n;
    }

    public static void main(String[] args) {
        No171 no171 = new No171();

        String s1 = "A";
        String s2 = "AB";
        String s3 = "ZY";

        System.out.println(no171.titleToNumber(s1));
        System.out.println(no171.titleToNumber(s2));
        System.out.println(no171.titleToNumber(s3));
    }
}
