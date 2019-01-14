package com.github.txb.leetcode.ans.no50;

/**
 * NO.7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example1:
 * Input: 123   Output:  321
 *
 * Example2:
 * Input: -123  Output: -321
 *
 * Example3:
 * Input: 120   Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * Created by tanghui on 2018/2/1.
 */
public class No7 {

    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        int res = 0;
        x = Math.abs(x);

        while (x > 0) {
            // 处理溢出的情况
            if (Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE - (x % 10) < res * 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }

        return sign * res;
    }

    public static void main(String[] args) {
        No7 no7 = new No7();
        System.out.println(no7.reverse(123));
        System.out.println(no7.reverse(-321));
        System.out.println(no7.reverse(12));
        System.out.println(no7.reverse(102));
        System.out.println(no7.reverse(Integer.MAX_VALUE));
    }
}
