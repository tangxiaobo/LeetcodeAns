package com.github.txb.leetcode.no250;

/**
 * NO.226. Invert Binary Tree
 *
 * Invert a binary tree.
 * Example:
 * Input:
 *          4
 *        /   \
 *       2     7
 *      / \   / \
 *     1   3 6   9
 * Output:
 *          4
 *        /   \
 *       7     2
 *      / \   / \
 *     9   6 3   1
 *
 * Created by tanghui on 2018/6/13.
 */
public class No226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
        @Override
        public String toString() {
            // 中序遍历 (左，中，右)
            return (null == left ? "" : left + ", ") + val + (null == right ? "" : ", " + right);
        }
    }

    public TreeNode invertTree(TreeNode node) {
        if (null == node) {
            return node;
        }
        TreeNode tmpNode = node.right;
        node.right = invertTree(node.left);
        node.left = invertTree(tmpNode);
        return node;
    }

    public static void main(String[] args) {
        No226 no226 = new No226();
        TreeNode node11 = no226.new TreeNode(4);
        TreeNode node21 = no226.new TreeNode(2);
        TreeNode node22 = no226.new TreeNode(7);
        TreeNode node31 = no226.new TreeNode(1);
        TreeNode node32 = no226.new TreeNode(3);
        TreeNode node33 = no226.new TreeNode(6);
        TreeNode node34 = no226.new TreeNode(9);
        node11.left = node21;
        node11.right = node22;
        node21.left = node31;
        node21.right = node32;
        node22.left = node33;
        node22.right = node34;

        System.out.println(node11);
        System.out.println(no226.invertTree(node11));
    }
}
