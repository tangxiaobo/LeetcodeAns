package com.github.txb.leetcode.ans.no200;

/**
 * NO.191. Number of 1 Bits
 *
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Example 1:
 * Input: 11
 * Output: 3
 * Explanation: Integer 11 has binary representation 00000000000000000000000000001011
 *
 * Example 2:
 * Input: 128
 * Output: 1
 * Explanation: Integer 128 has binary representation 00000000000000000000000010000000
 *
 * Created by tanghui on 2018/6/13.
 */
public class No191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int oneBits = 0;
        while (n != 0) {
            oneBits += n & 1;
            n >>>= 1;
        }
        return oneBits;
    }

    public static void main(String[] args) {
        No191 no191 = new No191();
        int n1 = 11;
        int n2 = 128;

        System.out.println(no191.hammingWeight(n1));
        System.out.println(no191.hammingWeight(n2));
    }
}
