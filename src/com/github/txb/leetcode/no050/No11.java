package com.github.txb.leetcode.no050;

/**
 * NO.11. Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Created by tanghui on 2018/2/8.
 */
public class No11 {

    /**
     * 左右向中间 每次移动短的 线段， 这样才有可能获取更大的面积
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        int h, w; // 高， 宽
        while (left < right) {
            w = right - left;
            if (height[left] > height[right]) {
                h = height[right];
                right--;
            } else {
                h = height[left];
                left++;
            }
            maxArea = Math.max(h * w, maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        No11 no11 = new No11();

        int[] height = new int[] {
                1, 2, 3, 4
        };

        System.out.println(no11.maxArea(height));
    }
}
