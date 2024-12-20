package leetcodeZoho3;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class CircularLinkedList {
	Node head = null;

	// Function to insert a node in a sorted circular linked list
	public void sortedInsert(int data) {
		Node newNode = new Node(data);

		// Case 1: If the list is empty
		if (head == null) {
			newNode.next = newNode; // Point to itself
			head = newNode;
			return;
		}

		Node current = head;

		// Case 2: Insert before the head (new node has the smallest value)
		if (data < head.data) {
			// Find the last node to complete the circular structure
			while (current.next != head) {
				current = current.next;
			}
			current.next = newNode; // Last node points to the new node
			newNode.next = head; // New node points to head
			head = newNode; // New node becomes the head
		} else {
			// Case 3: Insert somewhere after the head
			while (current.next != head && current.next.data < data) {
				current = current.next;
			}
			// Insert the new node after the current node
			newNode.next = current.next;
			current.next = newNode;
		}
	}

	// Function to print the circular linked list
	public void printList() {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		Node temp = head;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != head);
		System.out.println();
	}

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();

		list.sortedInsert(5);
		list.sortedInsert(2);
		list.sortedInsert(8);
		list.sortedInsert(1);
		list.sortedInsert(7);

		// The list should be: 1 -> 2 -> 5 -> 7 -> 8 (circular)
		list.printList();
	}
}
