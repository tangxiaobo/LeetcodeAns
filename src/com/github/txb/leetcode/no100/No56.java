package com.github.txb.leetcode.no100;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NO.56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Created by tanghui on 2019/1/17.
 */
public class No56 {

    public List<Interval> merge(List<Interval> intervals) {
        if (null == intervals || intervals.size() == 0) {
            return intervals;
        }

        // sort list
        intervals = intervals.stream().sorted(Comparator.comparing(e -> e.start)).collect(Collectors.toList());

        List<Interval> res = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // add last one
        res.add(new Interval(start, end));

        return res;
    }

    /**
     * Definition for an interval.
     */
    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public static void main(String[] args) {
        // [[1,3],[2,6],[8,10],[15,18]]
        Interval interval11 = new Interval(1, 3);
        Interval interval12 = new Interval(2, 6);
        Interval interval13 = new Interval(8, 10);
        Interval interval14 = new Interval(15, 18);

        List<Interval> intervalList1 = new ArrayList<>();
        intervalList1.add(interval11);
        intervalList1.add(interval12);
        intervalList1.add(interval13);
        intervalList1.add(interval14);

        // [[1,4],[4,5]]
        Interval interval21 = new Interval(1, 4);
        Interval interval22 = new Interval(4, 5);
        List<Interval> intervalList2 = new ArrayList<>();
        intervalList2.add(interval21);
        intervalList2.add(interval22);


        No56 no56 = new No56();
        System.out.println(intervalList1);
        System.out.println(no56.merge(intervalList1));
        System.out.println(intervalList2);
        System.out.println(no56.merge(intervalList2));
    }

}
