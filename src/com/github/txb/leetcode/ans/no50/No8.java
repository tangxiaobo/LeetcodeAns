package com.github.txb.leetcode.ans.no50;

/**
 * NO.8. String to Integer (atoi)
 *
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases.
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 *
 *
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * Created by tanghui on 2018/2/7.
 */
public class No8 {

    public int myAtoi(String str) {
        // 1. null or empty string
        if (str == null || str.length() == 0)
            return 0;

        // 2. whitespaces
        str = str.trim();

        int len = str.length();
        boolean negative = false;

        double res = 0; // 结果
        int i = 0; // index
        char c;
        if (len > 0) {
            // 处理符号 +- sign
            c = str.charAt(0);
            if ('-' == c || '+' == c) {
                negative = '-' == c;
                i++;
            }

            // 处理剩下的部分
            while (i < len) {
                 c = str.charAt(i++);
                 if ('0' > c || '9' < c)
                     break;

                 // 计算数值，并处理溢出 溢出就返回边界值
                 if (negative) {
                     res = res * 10 - (c - '0');
                     if (res < Integer.MIN_VALUE)
                         return Integer.MIN_VALUE;
                 } else {
                     res = res * 10 + c - '0';
                     if (res > Integer.MAX_VALUE)
                         return Integer.MAX_VALUE;
                 }
            }
        }

        return (int) res;
    }

    public static void main(String[] args) {
        No8 no8 = new No8();

        System.out.println(no8.myAtoi("-111.9"));
        System.out.println(no8.myAtoi("    010"));
        System.out.println(no8.myAtoi("     +004500"));
    }
}
