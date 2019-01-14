package com.github.txb.leetcode.no050;

import java.util.Arrays;

/**
 * NO.23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * Created by tanghui on 2019/1/14.
 */
public class No23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resNode = new ListNode(0); //Node helper
        ListNode currNode = resNode;

        boolean loopFlag = true;
        while (loopFlag) {
            loopFlag = false;

            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (null != lists[i]) {
                    loopFlag = true;
                    if (index < 0) {
                        index = i;
                    }
                    if (lists[i].val < lists[index].val) {
                        index = i;
                    }
                }
            }

            if (loopFlag) {
                currNode.next = lists[index];
                currNode = currNode.next;

                // 最小 node 滑动
                lists[index] = lists[index].next;
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
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(5);
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;

        ListNode listNode31 = new ListNode(2);
        ListNode listNode32 = new ListNode(6);
        listNode31.next = listNode32;

        ListNode[] listNodes = new ListNode[] {
                listNode11, listNode21, listNode31
        };

        No23 no23 = new No23();

        System.out.println(Arrays.toString(listNodes));
        System.out.println(no23.mergeKLists(listNodes));


    }

}
