import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


/**

103. Binary Tree Zigzag Level Order Traversal
Medium

2960

120

Add to List

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


**/


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val){
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

}
public class ZigZagLevelOrderTraversal {

	private List<List<Integer>>  zigZagLevelOrderTraversal(TreeNode root){
		List<List<Integer>>  ans = new ArrayList<>();
		if(root == null) return ans;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean flag = false;
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<size; i++){
				TreeNode node = queue.remove();
				if(flag){
					list.add(0,node.val);
				}else{
					list.add(node.val);
				}
				if(node.left!=null) queue.add(node.left);
				if(node.right!=null) queue.add(node.right);
			}
			ans.add(list);
			flag = !flag;
		}
		return ans;
	}

	public static void main(String[] args) {
		ZigZagLevelOrderTraversal z = new ZigZagLevelOrderTraversal();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> list = z.zigZagLevelOrderTraversal(root);
		System.out.println(list);
	}
}