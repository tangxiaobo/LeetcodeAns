package com.github.txb.leetcode.no050;

/**
 * NO.25. Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * Created by tanghui on 2019/1/16.
 */
public class No25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode resNode = new ListNode(0);
        resNode.next = head;

        ListNode left = resNode;
        ListNode right = resNode;
        ListNode tmp;

        while (true) {
            // find kth listNode
            int i = 0;
            while (null != right.next && i < k) {
                right = right.next;
                i++;
            }

            if (i == k) {
                head = left.next;
                // reverse
                while (left.next != right) {
                    tmp = left.next;
                    left.next = tmp.next;
                    tmp.next = right.next;
                    right.next = tmp;
                }
                left = right = head;
            }

            if (null == right.next) {
                break;
            }
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
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        No25 no25 = new No25();
        System.out.println(listNode1);
        System.out.println(no25.reverseKGroup(listNode1, 2));

    }
}
