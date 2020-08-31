import java.util.Set;
import java.util.HashSet;

/**


LC 141. Linked List Cycle  // Easy

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.


 

Follow up:

Can you solve it using O(1) (i.e. constant) memory?


**/



class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		this.val = x;
	}
}
public class LinkedListCycles {


	//using two pointers 
	public boolean hasCycle(ListNode head) {

        if(head == null || head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;            
        }
        return true;
    }

    //using hashset

    public boolean hasCycleII(ListNode head) {
      Set<ListNode> nodeSeen = new HashSet<>();
        while(head!=null){
            if(nodeSeen.contains(head)){
               return true; 
            }else{
                nodeSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

	public static void main(String[] args) {
		LinkedListCycles rlist = new LinkedListCycles();

		ListNode l1= new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next = new ListNode(6);
		l1.next.next.next.next.next.next = l1.next.next.next;


		//rlist.display(l1);

		System.out.println(rlist.hasCycle(l1));
		System.out.println(rlist.hasCycleII(l1));

	}


	public void display(ListNode node){
		while(node !=null){
			System.out.print(node.val+"->");
			node = node.next;
		}
		System.out.print("null\n");
	}
}
