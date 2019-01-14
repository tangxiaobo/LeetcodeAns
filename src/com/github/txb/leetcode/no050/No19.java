package com.github.txb.leetcode.no050;

/**
 * NO.19. Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 *
 * Follow up:
 * Could you do this in one pass?
 *
 * Created by tanghui on 2019/1/14.
 */
public class No19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode resNode = new ListNode(0);
        resNode.next = head;

        ListNode left = resNode;
        ListNode right = resNode;
        int i = 0;
        while (null != right.next) {
            if (i >= n) {
                left = left.next;
            }

            right = right.next;
            i++;
        }

        // remove left.next element
        left.next = left.next.next;

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

        int reIdx = 2;

        No19 no19 = new No19();

        System.out.println(listNode1);
        System.out.println(no19.removeNthFromEnd(listNode1, reIdx));
    }
}
