package com.github.txb.leetcode.ans.no50;

import java.util.Arrays;

/**
 * NO.1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * Created by tanghui on 2018/2/4.
 */
public class No1 {

    public int[] twoSum(int[] nums, int target) {
        // 两层循环对比结果
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        No1 no1 = new No1();
        int[] res = no1.twoSum(nums, target);

        System.out.println(Arrays.toString(res));
    }
}
