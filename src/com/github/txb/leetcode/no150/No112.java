package com.github.txb.leetcode.no150;

/**
 * NO.112. Path Sum
 *
 *  Given a binary tree and a sum,
 *  determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 *  Note: A leaf is a node with no children.
 *
 *  Example:
 *  Given the below binary tree and sum = 22,
 *
 *          5
 *         / \
 *        4   8
 *       /   / \
 *      11  13  4
 *     /  \      \
 *    7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * Created by tanghui on 2018/6/5.
 */
public class No112 {

    public boolean hasPathSum(TreeNode node, int val) {
        if (null == node)
            return false;
        if (null == node.left && null == node.right && node.val == val)
            return true;

        return hasPathSum(node.left, val - node.val) || hasPathSum(node.right, val - node.val);
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        No112 no112 = new No112();
        TreeNode l1node5 = no112.new TreeNode(5);
        TreeNode l2node4 = no112.new TreeNode(4);
        TreeNode l2node8 = no112.new TreeNode(8);
        TreeNode l3node11 = no112.new TreeNode(11);
        TreeNode l3node13 = no112.new TreeNode(13);
        TreeNode l3node4 = no112.new TreeNode(4);
        TreeNode l4node7 = no112.new TreeNode(7);
        TreeNode l4node2 = no112.new TreeNode(2);
        TreeNode l4node1 = no112.new TreeNode(1);

        l1node5.left = l2node4;
        l1node5.right = l2node8;

        l2node4.left = l3node11;
        l2node8.left = l3node13;
        l2node8.right = l3node4;

        l3node11.left = l4node7;
        l3node11.right = l4node2;
        l3node4.right = l4node1;

        System.out.println(no112.hasPathSum(l1node5, 22));
    }

}
