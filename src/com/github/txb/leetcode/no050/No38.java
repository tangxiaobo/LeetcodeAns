package com.github.txb.leetcode.no050;

/**
 * NO.38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 * Input: 1
 * Output: "1"
 *
 * Example 2:
 * Input: 4
 * Output: "1211"
 *
 * Created by tanghui on 2018/6/4.
 */
public class No38 {

    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder().append('1');

        for (int i = 1; i < n; i++) {
            char before = res.charAt(0);
            int times = 0;
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < res.length(); j++) {
                if (before == res.charAt(j)) {
                    times++;
                } else {
                    tmp.append(times).append(before);
                    times = 1;
                    before = res.charAt(j);
                }
            }
            // 末尾的数据添加上
            tmp.append(times).append(before);
            res = tmp;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        No38 no38 = new No38();

        System.out.println(no38.countAndSay(1));
        System.out.println(no38.countAndSay(4));
    }
}
