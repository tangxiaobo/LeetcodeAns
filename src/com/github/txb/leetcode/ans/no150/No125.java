package com.github.txb.leetcode.ans.no150;

/**
 * NO.125. Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 *
 * Created by tanghui on 2018/6/8.
 */
public class No125 {

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char head = s.charAt(i), tail = s.charAt(j);
            // 判断是否为 字母
            if (head < '0' || (head > '9' && head < 'A') || (head > 'Z' && head < 'a') || head > 'z') {
                i++;
                continue;
            }
            if (tail < '0' || (tail > '9' && tail < 'A') || (tail > 'Z' && tail < 'a') || tail > 'z') {
                j--;
                continue;
            }

            // 数字必须相等
            if (head >= '0' && head <= '9') {
                if (head != tail) {
                    return false;
                }
            } else if (head != tail && head - tail != 'a' - 'A' && tail - head != 'a' - 'A') {
                // 字母忽略大小写
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        No125 no125 = new No125();

        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a ca";
        String str3 = "0P";

        System.out.println(no125.isPalindrome(str1));
        System.out.println(no125.isPalindrome(str2));
        System.out.println(no125.isPalindrome(str3));
    }
}
