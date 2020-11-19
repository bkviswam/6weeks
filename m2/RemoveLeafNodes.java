

/**

1325. Delete Leaves With a Given Value
Medium

519

12

Add to List

Share
Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).

 

Example 1:



Input: root = [1,2,3,2,null,2,4], target = 2
Output: [1,null,3,null,4]
Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left). 
After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
Example 2:



Input: root = [1,3,3,3,2], target = 3
Output: [1,3,null,null,2]
Example 3:



Input: root = [1,2,null,2,null,2], target = 2
Output: [1]
Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
Example 4:

Input: root = [1,1,1], target = 1
Output: []
Example 5:

Input: root = [1,2,3], target = 1
Output: [1,2,3]
 

Constraints:

1 <= target <= 1000
The given binary tree will have between 1 and 3000 nodes.
Each node's value is between [1, 1000].

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


public class RemoveLeafNodes {

	public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeLeafNodesRec(root, target);
    }

    public TreeNode removeLeafNodesRec(TreeNode node, int target){
    	if(node == null){
    		return null;
    	}
    	node.left = removeLeafNodesRec(node.left, target);
    	node.right = removeLeafNodesRec(node.right, target);

    	if(node.val == target && node.left == null && node.right == null){
    		return null;
    	}
    	return node;
    }


	public void inorder(TreeNode root){
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		RemoveLeafNodes rlf = new RemoveLeafNodes();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);

		rlf.inorder(root);
		System.out.println();
		int target = 2;
		rlf.removeLeafNodes(root, target);
		rlf.inorder(root);
		System.out.println();

	}
}