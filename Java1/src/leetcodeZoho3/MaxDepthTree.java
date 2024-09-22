package leetcodeZoho3;

public class MaxDepthTree {

	static class Node {
		int data;
		Node left, right;

		Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}

	static int maxDepth(Node node) {
		if (node == null)
			return 0;

		int lDepth = maxDepth(node.left);
		int rDepth = maxDepth(node.right);

		return Math.max(lDepth, rDepth) + 1;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(20);
		root.left.right = new Node(30);
		root.left.right.right = new Node(40);
		System.out.println(maxDepth(root));
	}
}
