package com.github.txb.leetcode.ans.no50;

/**
 * NO.2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 *
 * Add the two numbers and return it as a linked list.You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * Created by tanghui on 2018/1/30.
 */
public class No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(0);
        ListNode m = l1, n = l2;
        int carry = 0;
        ListNode current = resNode;

        // 迭代
        while (null != m || null != n) {
            int x = null == m ? 0 : m.val;
            int y = null == n ? 0 : n.val;

            int sum = x + y + carry;

            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            // 有一个链表为 null 之后 只添加其中一个
            if (null != m) {
                m = m.next;
            }
            if (null != n) {
                n = n.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return resNode.next;
    }

    /**
     * 链表节点
     */
    private final static class ListNode {
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
        ListNode listNode12 = new ListNode(2);
        ListNode listNode14 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);

        ListNode listNode25 = new ListNode(5);
        ListNode listNode26 = new ListNode(6);
        ListNode listNode24 = new ListNode(4);

        listNode12.next = listNode14;
        listNode14.next = listNode13;

        listNode25.next = listNode26;
        listNode26.next = listNode24;

        No2 no2 = new No2();

        System.out.println(listNode12);
        System.out.println(listNode25);

        ListNode listNodeRes = no2.addTwoNumbers(listNode12, listNode25);
        System.out.println(listNodeRes);

    }

}
