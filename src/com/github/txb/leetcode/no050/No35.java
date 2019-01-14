package com.github.txb.leetcode.no050;

/**
 * NO.35. Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * Created by tanghui on 2018/6/1.
 */
public class No35 {

    public int searchInsert(int[] nums, int target) {

        //return binarySearch(nums, 0 , nums.length, target);

        // 迭代二分查找
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    /**
     * 递归
     * 二分查找
     */
    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start == end)
            return start;

        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;

        if (nums[mid] < target)
            return binarySearch(nums, mid + 1, end, target);

        return binarySearch(nums, start, mid, target);
    }

    public static void main(String[] args) {
        No35 no35 = new No35();

        int[] nums = {1, 3, 5, 6};
        int target1 = 5, target2 = 2, target3 = 7, target4 = 0;

        System.out.println(no35.searchInsert(nums, target1));
        System.out.println(no35.searchInsert(nums, target2));
        System.out.println(no35.searchInsert(nums, target3));
        System.out.println(no35.searchInsert(nums, target4));
    }
}
