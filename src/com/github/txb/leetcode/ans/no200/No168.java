package com.github.txb.leetcode.ans.no200;

/**
 * NO.168. Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * Example 1:
 * Input: 1
 * Output: "A"
 *
 * Example 2:
 * Input: 28
 * Output: "AB"
 *
 * Example 3:
 * Input: 701
 * Output: "ZY"
 *
 * Created by tanghui on 2018/6/12.
 */
public class No168 {

    public String convertToTitle(int n) {
        //本质 10 进制转 26 进制
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--; //A 是从1 开始的, 701 = 26 * 26 + 25 == Z(25 + 1)Y(24 + 1)
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No168 no168 = new No168();

        int n1 = 1, n2 = 28, n3 = 701;
        System.out.println(no168.convertToTitle(n1));
        System.out.println(no168.convertToTitle(n2));
        System.out.println(no168.convertToTitle(n3));
    }

}
