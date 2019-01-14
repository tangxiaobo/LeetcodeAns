package com.github.txb.leetcode.no300;

/**
 * NO.258. Add Digits
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * Created by tanghui on 2018/6/13.
 */
public class No258 {

    public int addDigits1(int num) {
        if (num >= 0 && num <= 9) {
            return num;
        }

        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }

        return addDigits1(res);
    }

    public int addDigits(int num) {
        return num != 0 ? (num % 9 != 0 ? num % 9 : 9) : 0;
    }

    public static void main(String[] args) {
        No258 no258 = new No258();
        int num1 = 38;
        int num2 = 0;
        System.out.println(no258.addDigits(num1));
        System.out.println(no258.addDigits(num2));
    }

}
