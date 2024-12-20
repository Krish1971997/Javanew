package geeksforgeeksZoho;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	private Node head;

	public LinkedList() {
		this.head = null;
	}

	// Insert a new node at the end of the linked list
	public void insert(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			head = current;
		}
	}

	// Remove a node with the given data from the linked list
	public void remove(int data) {
		if (head == null) {
			return;
		}

		if (head.data == data) {
			head = head.next;
			return;
		}

		Node current = head;
		Node prev = null;

		while (current != null && current.data != data) {
			prev = current;
			current = current.next;
		}

		if (current == null) {
			return; // Data not found in the linked list
		}

		prev.next = current.next;
	}
	
	 public Node reverseList() {
	        Node prev = null;
	        Node current = head;

	        while (current != null) {
	            Node nextTemp = current.next;
	            current.next = prev;
	            prev = current;
	            current = nextTemp;
	        }
	        head=prev;
	        return head; // New head of the reversed list
	    }

	// Retrieve all elements of the linked list
	public void retrieveAll() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		java.util.LinkedList<String> s = new java.util.LinkedList<String>();
		s.add("10");

		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);

		System.out.println("Linked List after insertion:");
		linkedList.retrieveAll();

		linkedList.remove(4);
		linkedList.insert(6);

		System.out.println("Linked List after removal:");
		linkedList.retrieveAll();
		System.out.println("Reverse");
		linkedList.reverseList();
		linkedList.retrieveAll();
		
	}
}
