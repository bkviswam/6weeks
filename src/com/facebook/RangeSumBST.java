package com.facebook;

import java.util.Stack;

/**
 * 938. Range Sum of BST
 * <p>
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 */

public class RangeSumBST {
    //bfs
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high)
                    ans += node.val;
                if (low < node.val) stack.push(node.left);
                if (node.val > high) stack.push(node.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RangeSumBST rs = new RangeSumBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rs.rangeSumBST(root, 7, 15));
    }
}
