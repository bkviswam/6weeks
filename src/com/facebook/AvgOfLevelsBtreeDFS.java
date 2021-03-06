package com.facebook;

import java.util.ArrayList;
import java.util.List;

public class AvgOfLevelsBtreeDFS {
    List<Sum> list = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);
        List<Double> result = new ArrayList<>();
        for (Sum s : list) {
            result.add(s.sum / s.size);
        }
        return result;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (list.size() == level) {
            list.add(new Sum(node.val, 1));
        } else {
            Sum s = list.get(level);
            s.sum += node.val;
            s.size++;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public static void main(String[] args) {
        AvgOfLevelsBtreeDFS t = new AvgOfLevelsBtreeDFS();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(11);
        System.out.println("Average Of levels of BTree :" + t.averageOfLevels(root));
    }
}
