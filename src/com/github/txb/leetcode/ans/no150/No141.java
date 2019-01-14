package com.github.txb.leetcode.ans.no150;

/**
 * NO.141. Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * Created by tanghui on 2018/6/12.
 */
public class No141 {

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

    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }

        ListNode slower = head;
        ListNode faster = head;
        // 两个指针速率不一样，如果存在环状链表，快的指针终究会追上慢的指针
        // 而且 faster 会比较快，只需要判断快的指针就行
        while (null != faster.next && null != faster.next.next) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        No141 no141 = new No141();

        ListNode cycleNode = no141.new ListNode(-1);
        ListNode node11 = no141.new ListNode(1);
        ListNode node12 = no141.new ListNode(2);
        ListNode node13 = no141.new ListNode(3);
        ListNode node14 = no141.new ListNode(4);
        ListNode node15 = no141.new ListNode(5);
        cycleNode.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node12;

        ListNode noCycleNode = no141.new ListNode(-1);
        ListNode node21 = no141.new ListNode(1);
        ListNode node22 = no141.new ListNode(2);
        ListNode node23 = no141.new ListNode(3);
        ListNode node24 = no141.new ListNode(4);
        ListNode node25 = no141.new ListNode(5);
        noCycleNode.next = node21;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;

        System.out.println(no141.hasCycle(cycleNode));
        System.out.println(no141.hasCycle(noCycleNode));
    }
}
