class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		this.val = x;
	}
}

class LengthOfLinkedList {

	//recursive 
	public int getLength(ListNode head){
		if(head==null){
			return 0;
		}
		return 1 + getLength(head.next);
	}

	//iterative

	public int getLengthIter(ListNode head){
		if(head==null){
			return 0;
		}
		int count = 0;
		while(head != null){
			++count;
			head = head.next;
		}
		return count;
	}

	public void display(ListNode node){
		while(node !=null){
			System.out.print(node.val+"->");
			node = node.next;
		}
		System.out.print("null\n");
	}

	public static void main(String[] args) {
		LengthOfLinkedList len = new LengthOfLinkedList();
		ListNode l1= new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next = new ListNode(6);
		l1.next.next.next.next.next.next = new ListNode(7);
		len.display(l1);
		System.out.println("The length of linked list "+len.getLength(l1));
		System.out.println("The length of linked list "+len.getLengthIter(l1));
	}

}