public class MyQueue {

	public  class Node {
		int data;
		Node next; 
		public Node(int data){
			this.data = data;
		}
	}

	public Node head;
	public Node tail;

	public boolean isEmpty(){
		return head == null;
	}

	public int peek(){
		if (!isEmpty()){
			return head.data;
		}
		return -1;
	}
	public void add(int data){
		Node node = new Node(data);
		if(tail !=null){
			tail.next = node;
		}
		tail = node;
		if (head==null){
			head = node;
		}
	}

	public int remove(){
		int data = -1;
		if(!isEmpty()){
			data = head.data;
			head = head.next;
		}
		if(head == null){
			tail = null;
		}
		return data;
	}

	public static void main(String[] args) {
		MyQueue q = new MyQueue();

		System.out.println("Q empty :"+q.isEmpty()); 
		q.add(1);
		System.out.println("Head : "+q.head.data); 
		System.out.println("Tail : "+q.tail.data); 
		q.add(2);
		System.out.println("Head : "+q.head.data); 
		System.out.println("Tail : "+q.tail.data); 
		q.display(q.head);
		System.out.println("Q empty :"+q.isEmpty()); 
		q.add(3);
		q.add(100);
		q.display(q.head);
		q.add(200);
		q.add(300);
		System.out.println("Head : "+q.head.data); 
		System.out.println("Tail : "+q.tail.data); 
		System.out.println("Peek --: "+q.peek());
		q.display(q.head);
		System.out.println("Removed --: "+q.remove());
		System.out.println("Removed --: "+q.remove());
		System.out.println("Head : "+q.head.data); 
		System.out.println("Tail : "+q.tail.data); 
		q.display(q.head);
		System.out.println("Peek --: "+q.peek());
		System.out.println("Removed --: "+q.remove());
		System.out.println("Removed --: "+q.remove());
		System.out.println("Removed --: "+q.remove());
		System.out.println("Removed --: "+q.remove());
		System.out.println("Q empty :"+q.isEmpty()); 
		System.out.println("Removed --: "+q.remove());
		System.out.println("Removed --: "+q.remove());

	}

	public void display(Node node){
		while(node!=null){
			System.out.print(node.data+"-->");
			node = node.next;
		}
		System.out.println("null");
	}

}