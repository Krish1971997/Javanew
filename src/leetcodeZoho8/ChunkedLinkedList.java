package leetcodeZoho8;

class ChunkedLinkedList {

	class Node {
		int[] elements;
		int count;
		Node next;

		Node(int chunkSize) {
			elements = new int[chunkSize];
			count = 0;
			next = null;
		}
	}

	private Node head;
	private int chunkSize;

	public ChunkedLinkedList(int chunkSize) {
		this.chunkSize = chunkSize;
		head = new Node(chunkSize);
	}

	public void insert(int value) {
		Node temp = head;

		// Move to last node
		while (temp.next != null) {
			temp = temp.next;
		}

		// If current node is full, create new node
		if (temp.count == chunkSize) {
			temp.next = new Node(chunkSize);
			temp = temp.next;
		}

		temp.elements[temp.count++] = value;
	}

	public void display() {
		Node temp = head;

		while (temp != null) {
			for (int i = 0; i < temp.count; i++) {
				System.out.print(temp.elements[i] + " ");
			}
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ChunkedLinkedList list = new ChunkedLinkedList(4);

		for (int i = 1; i <= 9; i++) {
			list.insert(i);
		}

		list.display();
	}
}