
/**

Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

 

Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
Example 3:

Input: head = [1]
Output: 1
Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
Example 5:

Input: head = [0,0]
Output: 0
 

Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.

**/


class ListNode {
	ListNode next;
	int val;
	public ListNode(int x){
		this.val = x;
	}
}

public class ConvertBinaryLLToInt{

	public int getDecimalValue(ListNode head){
		int num = head.val;
		while(head.next != null){
			num = num * 2 + head.next.val;
			head = head.next;
		}
		return num;
	}


	public static void main(String[] args) {
		ConvertBinaryLLToInt   ci = new ConvertBinaryLLToInt();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(0);
		
		System.out.println("The Linked List ");
		ci.display(head);
		System.out.println("The decimal Number "+ci.getDecimalValue(head));


	}
	public void display(ListNode head){
		while(head!=null){
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("null");
	}
}