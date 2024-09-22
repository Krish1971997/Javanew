package leetcodeZoho3;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbersRecursive(l1, l2, 0);
	}

	private ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2, int carry) {
		// Base case: If both lists are null and there's no carry, return null
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		// Calculate the value and carry
		int sum = carry;
		if (l1 != null) {
			sum += l1.val;
			l1 = l1.next;
		}
		if (l2 != null) {
			sum += l2.val;
			l2 = l2.next;
		}

		// Create a new node with the sum's unit digit
		ListNode resultNode = new ListNode(sum % 10);

		// Recursively call for the next nodes
		resultNode.next = addTwoNumbersRecursive(l1, l2, sum / 10);

		return resultNode;
	}

	public static void main(String[] args) {
		// Number 342 represented as 2 -> 4 -> 3
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		// Number 465 represented as 5 -> 6 -> 4
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		AddTwoNumbers solution = new AddTwoNumbers();
		ListNode result = solution.addTwoNumbers(l1, l2);

		// Output the result: 7 -> 0 -> 8
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
