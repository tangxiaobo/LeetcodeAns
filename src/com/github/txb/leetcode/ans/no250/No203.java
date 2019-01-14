package com.github.txb.leetcode.ans.no250;

/**
 * NO.203. Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * Created by tanghui on 2018/6/8.
 */
public class No203 {

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


    public ListNode removeElements(ListNode head, int val) {
        // 因为原来的头部节点可能删除，因此借用额外的节点来避免该问题，同时返回的时候使用该节点的next
        ListNode first = new ListNode(0);
        first.next = head;

        ListNode prev = first, current = first.next;
        while (null != current) {
            if (current.val == val) {
                prev.next = null;
            } else {
                prev.next = current;
                prev = current;
            }

            current = current.next;
        }

        return first.next;
    }

    public static void main(String[] args) {
        No203 no203 = new No203();

        ListNode node1 = no203.new ListNode(1);
        ListNode node2 = no203.new ListNode(2);
        ListNode node3 = no203.new ListNode(6);
        ListNode node4 = no203.new ListNode(3);
        ListNode node5 = no203.new ListNode(4);
        ListNode node6 = no203.new ListNode(5);
        ListNode node7 = no203.new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        int target = 6;

        ListNode node8 = no203.new ListNode(1);
        int target2 = 2;

        System.out.println(no203.removeElements(node1, target));
        System.out.println(no203.removeElements(node8, target2));
    }
}
