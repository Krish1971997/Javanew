package leetcodeZoho;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
	
}

public class MergeSortedLinkedLists {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (a != null && b != null) {
			if (a.val < b.val) {
				current.next = a;
				a = a.next;
			} else {
				current.next = b;
				b = b.next;
			}
			current = current.next;
		}
		if (a != null) {
			current.next = a;
		}
		if (b != null) {
			current.next = b;
		}

		return dummy.next;
	}

	// Utility method to print the linked list
	public void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val);
			if (current.next != null) {
				System.out.print(" -> ");
			}
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MergeSortedLinkedLists merger = new MergeSortedLinkedLists();

		// Example 1
		ListNode a1 = new ListNode(5);
		a1.next = new ListNode(10);	
		a1.next.next = new ListNode(15);
		a1.next.next.next = new ListNode(30);
		a1.next.next.next.next = new ListNode(45);

		ListNode b1 = new ListNode(2);
		b1.next = new ListNode(3);
		b1.next.next = new ListNode(20);

		System.out.print("Input: ");
		merger.printList(a1);
		System.out.print("Input2:");
		merger.printList(b1);

		ListNode merged1 = merger.mergeTwoLists(a1, b1);
		System.out.print("Output: ");
		merger.printList(merged1);

		// Example 2
		ListNode a2 = new ListNode(1);
		a2.next = new ListNode(1);

		ListNode b2 = new ListNode(2);
		b2.next = new ListNode(4);

		System.out.print("Input: ");
		merger.printList(a2);
		System.out.print("        ");
		merger.printList(b2);

		ListNode merged2 = merger.mergeTwoLists(a2, b2);
		System.out.print("Output: ");
		merger.printList(merged2);
	}
}
