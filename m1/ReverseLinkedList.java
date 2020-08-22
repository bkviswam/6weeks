import java.util.Stack;

/**

206. Reverse Linked List  // Easy

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

**/

class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		this.val = x;
	}
}
public class ReverseLinkedList{
	//iterative
	public ListNode reverseLinkedList(ListNode l1){
		ListNode prev = null;
		ListNode current = l1;
		ListNode nextNode = null;
		while(current != null){
			nextNode = current.next;
			current.next = prev;
			prev  = current;
			current = nextNode;
		}
		return prev;
	}

	//recursive
	public ListNode reverseLinkedListRecursive(ListNode l1){
		return reverse(l1, null);
	}

	public ListNode  reverse(ListNode head, ListNode prev){
		ListNode nextNode = head.next;
		head.next = prev;
		if(nextNode == null){
			return head;
		}
		return reverse(nextNode, head);
	}


	public static void main(String[] args) {
		ReverseLinkedList rlist = new ReverseLinkedList();

		ListNode l1= new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);

		rlist.display(l1);
		rlist.display(rlist.reverseLinkedList(l1));
		//rlist.display(rlist.reverseLinkedListRecursive(l1));


	}
	public void display(ListNode node){
		while(node !=null){
			System.out.print(node.val+"->");
			node = node.next;
		}
		System.out.print("null\n");
	}
}