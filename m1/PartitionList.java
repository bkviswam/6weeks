/**

86. Partition List  //Medium


Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

**/


class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		this.val = x;
	}
}
public class PartitionList {


	public ListNode partition(ListNode head, int x){
		ListNode before_head = new ListNode(0);
		ListNode before = before_head;
		ListNode after_head = new ListNode(0);
		ListNode after = after_head;

		while(head !=null){

			if(head.val < x){
				before.next = head;
				before = before.next;
			}else{
				after.next = head;
				after = after.next;
			}
			head=head.next;
		}
		after.next = null;
		before.next = after_head.next;

		return before_head.next;
	}


	public static void main(String[] args) {
		PartitionList p = new PartitionList();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(2);
		l1.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next = new ListNode(2);
		p.display(l1);
		p.partition(l1,3);
		p.display(l1);
	}
	public void display(ListNode node){
		while(node !=null){
			System.out.print(node.val+"->");
			node = node.next;
		}
		System.out.print("null\n");
	}
}