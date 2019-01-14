package com.github.txb.leetcode.no300;

import java.util.Arrays;

/**
 * No.268. Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 *
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * Created by tanghui on 2018/6/13.
 */
public class No268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        No268 no268 = new No268();
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println(no268.missingNumber(nums1));
        System.out.println(no268.missingNumber(nums2));
    }

}
