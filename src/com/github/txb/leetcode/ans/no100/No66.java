package com.github.txb.leetcode.ans.no100;

import java.util.Arrays;

/**
 *
 * NO.66. Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * Created by tanghui on 2018/5/3.
 */
public class No66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 如果此时还没有终止循环，说明该位的上一位(右边)原来的数是9, +1 之后进进位了，因此此位也需要+1；
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // 此时还没有return 说明+1 之后整体进位了（原是 999...）
        int[] res = new int[digits.length + 1];
        res[0] = 1;

        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[] {
                1, 2, 3
        };
        int[] b = new int[] {
                4, 3, 2, 1
        };

        No66 no66 = new No66();
        System.out.println(Arrays.toString(no66.plusOne(a)));
        System.out.println(Arrays.toString(no66.plusOne(b)));
    }
}
