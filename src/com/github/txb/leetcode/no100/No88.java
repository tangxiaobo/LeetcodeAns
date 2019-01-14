package com.github.txb.leetcode.no100;

import java.util.Arrays;

/**
 * No.88. Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 * nums1 = [1,2,3,0,0,0],   m = 3
 * nums2 = [2,5,6],         n = 3
 * Output: [1,2,2,3,5,6]
 *
 * Created by tanghui on 2018/6/12.
 */
public class No88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        // 合并对比部分
        while (i > -1 && j > -1) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        // nums2 还存在没合并的就合并添加
        if (j > -1) {
            while (j > -1) {
                nums1[k--] = nums2[j--];
            }
        }
        // 如果 num1 还存在 不需要再次合并
    }

    public static void main(String[] args) {
        No88 no88 = new No88();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        System.out.println(Arrays.toString(nums1));
        no88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
