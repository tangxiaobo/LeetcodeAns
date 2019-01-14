package com.github.txb.leetcode.ans.no50;

/**
 * NO.9. alindrome Number
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Created by tanghui on 2018/2/7.
 */
public class No9 {

    /**
     * Method1: 判断收尾字母
     */
    public boolean isPalindrome1(int x) {
        if (x < 0)
            return false;

        int len = 1;
        while (x / len >= 10) // 此处如果判断1 有可能溢出
            len *= 10;
        // len /= 10; // 帮助获取高位数

        int left, right;
        while (x > 0) {
            //get the head and tail number
            left = x / len;
            right = x % 10;

            // 判断当前最高位和最低位 是否相等
            if (left != right)
                return false;

            // remove the head and tail number
            x = (x % len) / 10;
            //change len
            len /= 100; // 首尾去除了两位，所以此处是100
        }
        return true;
    }

    /**
     * 逆序后判断是否相等
     */
    public boolean isPalindrome(int x) {
        int res = 0, tmp = x;
        while (tmp > 0) {
            res = res * 10 + (tmp % 10);
            tmp /= 10;
        }
        return x == res;
    }

    public static void main(String[] args) {
        No9 no9 = new No9();

        System.out.println(no9.isPalindrome(12321));
        System.out.println(no9.isPalindrome(12323));
        System.out.println(no9.isPalindrome(1000000001));

        System.out.println(no9.isPalindrome1(12321));
        System.out.println(no9.isPalindrome1(12323));
        System.out.println(no9.isPalindrome1(1000000001));
    }
}
