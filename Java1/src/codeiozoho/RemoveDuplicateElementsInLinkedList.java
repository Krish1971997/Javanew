package codeiozoho;

class Node {
	int data;
	Node next;

	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}
}

public class RemoveDuplicateElementsInLinkedList {
	Node head;

	public void insert(int data) {
		Node newnode = new Node(data);
		if (head == null) {
			head = newnode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newnode;
			head = current;
		}
	}

	public void removeDuplicates() {
		Node current = head;
		while (current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else
				current = current.next;
		}
	}

	public void printlist() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + ", ");
			current = current.next;
		}
	}

	public static void main(String[] args) {
		RemoveDuplicateElementsInLinkedList r = new RemoveDuplicateElementsInLinkedList();
		r.insert(5);
		r.insert(5);
		r.insert(3);
		r.insert(2);
		r.insert(4);
		r.removeDuplicates();
		r.printlist();
	}
}
