package com.github.txb.leetcode.no200;

import java.util.Arrays;

/**
 * NO.167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * Created by tanghui on 2018/6/8.
 */
public class No167 {

    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length - 1;
        while (index1 < index2) {
            // 找到合适的值了
            if (numbers[index1] + numbers[index2] == target)
                break;

            // 大于目标值，index2 左移
            if (numbers[index1] + numbers[index2] > target)
                index2--;
            else
                // 小于目标值，index1 右移
                index1++;
        }

        return new int[]{index1 + 1, index2 + 1};
    }

    public static void main(String[] args) {
        No167 no167 = new No167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(no167.twoSum(numbers, target)));
    }
}
