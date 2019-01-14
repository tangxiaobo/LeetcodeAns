package com.github.txb.leetcode.no050;

/**
 * NO.6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * convert("ABCDEFGHIJKLMNOP", 4) should return "AGMBFHLNCEIKODJP"
 * A     G     M
 * B   F H   L N
 * C E   I K   O
 * D     J     P
 *
 * Created by tanghui on 2018/2/7.
 */
public class No6 {

    public String convert(String s, int numRows) {
        int len = s.length();

        if (numRows <= 1 || numRows >= len) {
            return s;
        }

        StringBuilder[] rowStrs = new StringBuilder[numRows];
        // init Array
        for (int i = 0; i < rowStrs.length; i++) {
            rowStrs[i] = new StringBuilder();
        }

        boolean isDown = true;
        int rowInd = 0;
        for (int i = 0; i < len; i++) {
            rowStrs[rowInd].append(s.charAt(i));

            rowInd += isDown ? 1 : -1;

            if (0 == rowInd)
                isDown = true;
            if (numRows - 1 == rowInd) {
                isDown = false;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder rowStr : rowStrs) {
            res.append(rowStr);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        No6 no6 = new No6();

        String s1 = "PAYPALISHIRING";
        System.out.println(no6.convert(s1, 3));

        String s2 = "ABCDEFGHIJKLMNOP";
        System.out.println(no6.convert(s2, 4));

        String s3 = "AB";
        System.out.println(no6.convert(s3, 1));
    }
}
