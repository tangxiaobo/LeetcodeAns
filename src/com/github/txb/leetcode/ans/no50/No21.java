package com.github.txb.leetcode.ans.no50;

/**
 * NO.21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * Created by tanghui on 2018/2/4.
 */
public class No21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);

        ListNode leftNode = l1;
        ListNode rightNode = l2;
        ListNode current = listNode;

        // 迭代
        while(null != leftNode && null != rightNode) {
            if (leftNode.val > rightNode.val) {
                current.next = rightNode;
                rightNode = rightNode.next;
            } else {
                current.next = leftNode;
                leftNode = leftNode.next;
            }
            current = current.next;
        }

        // 链接剩下的未添加的部分
        if (null != leftNode) {
            current.next = leftNode;
        }
        if (null != rightNode) {
            current.next = rightNode;
        }

        return listNode.next;
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
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode14 = new ListNode(4);

        ListNode listNode21 = new ListNode(1);
        ListNode listNode23 = new ListNode(3);
        ListNode listNode24 = new ListNode(4);

        listNode11.next = listNode12;
        listNode12.next = listNode14;

        listNode21.next = listNode23;
        listNode23.next = listNode24;

        No21 no21 = new No21();

        System.out.println(listNode11);
        System.out.println(listNode21);


        ListNode resListNode = no21.mergeTwoLists(listNode11, listNode21);
        System.out.println(resListNode);
    }
}
