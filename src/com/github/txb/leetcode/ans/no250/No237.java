package com.github.txb.leetcode.ans.no250;

/**
 * NO.237. Delete Node in a Linked List
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * 4 -> 5 -> 1 -> 9
 *
 * Example 1:
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5,
 *              the linked list should become 4 -> 1 -> 9 after calling your function.
 *
 * Example 2:
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1,
 *              the linked list should become 4 -> 5 -> 9 after calling your function.
 *
 * Note:
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 *
 * Created by tanghui on 2018/6/11.
 */
public class No237 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + (null == next ? "" : "->" + next);
        }
    }

    /**
     * 删除该 node
     * @param node 要被删除的 node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        No237 no237 = new No237();

        ListNode node1 = no237.new ListNode(4);
        ListNode node2 = no237.new ListNode(5);
        ListNode node3 = no237.new ListNode(1);
        ListNode node4 = no237.new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        no237.deleteNode(node3);
        System.out.println(node1);
        no237.deleteNode(node2);
        System.out.println(node1);
    }
}
