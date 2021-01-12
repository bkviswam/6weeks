import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


/**

Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,null,2]
Output: [1,2]
Example 5:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1

**/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class LargestTreeRow{
	//
	private List<Integer> largestValues(TreeNode root){
		List<Integer> ans = new ArrayList<Integer>();
		if(root==null) return ans;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int max = Integer.MIN_VALUE;
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode current = queue.remove();
				max = Math.max(current.val, max);
				if(current.left !=null) queue.add(current.left);
				if(current.right !=null) queue.add(current.right);
			}
			ans.add(max);
		}
		return ans;
	}


	public static void main(String[] args) {
		LargestTreeRow lr = new LargestTreeRow();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);

		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);

		root.right.right = new TreeNode(9);

		List<Integer> list = lr.largestValues(root);
		System.out.println(list);

	}
}