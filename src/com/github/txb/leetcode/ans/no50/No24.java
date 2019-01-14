package com.github.txb.leetcode.ans.no50;

/**
 * NO.24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Created by tanghui on 2019/1/11.
 */
public class No24 {

    public ListNode swapPairs(ListNode head) {
        ListNode resNode = new ListNode(0);
        resNode.next = head;

        ListNode curr = resNode;
        while (curr.next != null && curr.next.next != null) {

            // swap
            ListNode tmp = curr.next;
            curr.next = curr.next.next;
            tmp.next = curr.next.next;
            curr.next.next = tmp;


            // 持续循环
            curr = curr.next.next;
        }

        return resNode.next;
    }

    /**
     * 链表节点
     */
    private static final class ListNode {
        int val; // 当前节点的值
        ListNode next; // 下一个节点

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + (null == next ? "" : " -> " + next);
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        No24 no24 = new No24();
        System.out.println(listNode1);
        System.out.println(no24.swapPairs(listNode1));

    }

}
