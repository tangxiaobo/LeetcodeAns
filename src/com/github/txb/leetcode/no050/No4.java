package com.github.txb.leetcode.no050;

/**
 * NO.4. Median of Two Sorted Arrays
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 *
 * Created by tanghui on 2018/1/31.
 */
public class No4 {

    /**
     * Method1： （遍历合并数组）
     * 先计算下标，循环找到合适的下标之后，计算相应的值
     *
     * 待优化:
     * 1. r 下标的值出现后算法可以终止了
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int allSize = nums1.length + nums2.length;
        int r = allSize / 2;
        int l = r - (0 == allSize % 2 ? 1 : 0);

        int i, j, index;
        int tarl = 0, tarr = 0, current;
        for (i = j = index = 0; i < nums1.length && j < nums2.length && index < allSize; index++) {
            if (nums1[i] > nums2[j]) {
                current = nums2[j];
                j++;
            } else {
                current = nums1[i];
                i++;
            }

            // 找到合适的值
            if (l == index)
                tarl = current;
            if (r == index)
                tarr = current;
        }

        for (; j < nums2.length && index < allSize; j++, index++) {
            if (l == index)
                tarl = nums2[j];
            if (r == index)
                tarr = nums2[j];
        }

        for (; i < nums1.length && index < allSize; i++, index++) {
            if (l == index)
                tarl = nums1[i];
            if (r == index)
                tarr = nums1[i];
        }

        return (tarl + tarr) / 2.0;
    }

    public static void main(String[] args) {

        No4 no4 = new No4();
        int[] nums1 = new int[] {1, 3};
        int[] nums2 = new int[] {2};
        System.out.println(no4.findMedianSortedArrays1(nums1, nums2));

        int[] nums3 = new int[] {2};
        int[] nums4 = new int[] {0};
        System.out.println(no4.findMedianSortedArrays1(nums3, nums4));
    }
}
