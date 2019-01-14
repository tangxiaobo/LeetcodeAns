package com.github.txb.leetcode.no250;

/**
 * NO.206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * Created by tanghui on 2018/6/11.
 */
public class No206 {

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

    public ListNode reverseList(ListNode head) {
        // 该过程类似于 JDk1.7 里面 HashMap 的 resize 的过程
        ListNode first = new ListNode(0);
        ListNode current = head;

        while (null != current) {
            ListNode tmp = current.next;
            current.next = first.next;
            first.next = current;
            current = tmp;
        }

        return first.next;
    }

    public static void main(String[] args) {
        No206 no206 = new No206();

        ListNode node1 = no206.new ListNode(1);
        ListNode node2 = no206.new ListNode(2);
        ListNode node3 = no206.new ListNode(3);
        ListNode node4 = no206.new ListNode(4);
        ListNode node5 = no206.new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(no206.reverseList(node1));
    }
}
