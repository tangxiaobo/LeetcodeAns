package com.github.txb.leetcode.ans.no100;

/**
 * NO.67. Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Created by tanghui on 2018/5/7.
 */
public class No67 {

    public String addBinary(String a, String b) {
        int i = a.length() -1, j = b.length() -1, carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0)
            sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No67 no67 = new No67();

        String a1 = "11", b1 = "1";
        String a2 = "1010", b2 = "1011";

        System.out.println(no67.addBinary(a1, b1));
        System.out.println(no67.addBinary(a2, b2));
    }
}
