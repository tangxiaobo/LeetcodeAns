package com.github.txb.leetcode.no100;

/**
 * NO.83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * Created by tanghui on 2018/6/8.
 */
public class No83 {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + (null == next ? "" : "->" + next);
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode before = head, current = head.next;
        while (null != current) {
            if (before.val == current.val) {
                before.next = null;
            } else {
                before.next = current;
                before = current;
            }

            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        No83 no83 = new No83();
        ListNode node11 = no83.new ListNode(1);
        ListNode node12 = no83.new ListNode(1);
        ListNode node13 = no83.new ListNode(2);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = no83.new ListNode(1);
        ListNode node22 = no83.new ListNode(1);
        ListNode node23 = no83.new ListNode(2);
        ListNode node24 = no83.new ListNode(3);
        ListNode node25 = no83.new ListNode(3);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;

        System.out.println(no83.deleteDuplicates(node11));
        System.out.println(no83.deleteDuplicates(node21));
    }

}
