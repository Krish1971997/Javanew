package leetcodeZoho;

public class ReverseLinkedList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}

		return prev;
	}

	// Utility function to print the linked list
	public void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Example 1: 1->2->3->4->NULL
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);

		ReverseLinkedList solution = new ReverseLinkedList();
		System.out.println("Original list:");
		solution.printList(head1);

		ListNode reversedHead1 = solution.reverseList(head1);
		System.out.println("Reversed list:");
		solution.printList(reversedHead1);

		// Example 2: 1->2->3->4->5->NULL
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(4);
		head2.next.next.next.next = new ListNode(5);

		System.out.println("Original list:");
		solution.printList(head2);

		ListNode reversedHead2 = solution.reverseList(head2);
		System.out.println("Reversed list:");
		solution.printList(reversedHead2);
	}
}
