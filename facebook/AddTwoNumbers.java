/**

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.


**/

class ListNode {
	int val;
	ListNode next;
	public ListNode(){}
	public ListNode(int val){
		this.val = val;
	}
	public ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
}

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		return dfs(l1, l2, 0);
	}

	public ListNode dfs(ListNode l1, ListNode l2, int carry){
		if(l1==null && l2==null && carry ==0) return null;
		if(l1==null && l2==null && carry !=0) return new ListNode(1);

		int sum = ((l1!=null)?l1.val:0) + ((l2!=null)?l2.val:0 )+ carry;
		ListNode node = new ListNode(sum%10);
		node.next = dfs(l1!=null?l1.next:null, l2!=null?l2.next:null, sum/10);
		return node; 
	}



	public static void main(String[] args) {
		AddTwoNumbers an = new AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		 	l1.next = new ListNode(4);
		    l1.next.next = new ListNode(3);

		 ListNode l2 = new ListNode(5);
		 	l2.next = new ListNode(6);
		    l2.next.next = new ListNode(4);

		    an.display(l1);
		    an.display(l2);

		    an.display(an.addTwoNumbers(l1, l2));

	}

	public void display(ListNode node){
		while(node!=null){
			System.out.print(node.val+"->");
			node = node.next;
		}
		System.out.println("null");
	}

}