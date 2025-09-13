package leetcodeZoho7;

import java.util.Scanner;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
	}
}

class Tree {
	Node root;

	// Left View
	void leftView(Node node) {
		leftViewUtil(node, 1, new int[] { 0 });
		System.out.println();
	}

	void leftViewUtil(Node node, int level, int[] maxLevel) {
		if (node == null)
			return;

		if (maxLevel[0] < level) {
			System.out.print(node.data + " ");
			maxLevel[0] = level;
		}

		leftViewUtil(node.left, level + 1, maxLevel);
		leftViewUtil(node.right, level + 1, maxLevel);
	}

	// Right View
	void rightView(Node node) {
		rightViewUtil(node, 1, new int[] { 0 });
		System.out.println();
	}

	void rightViewUtil(Node node, int level, int[] maxLevel) {
		if (node == null)
			return;

		if (maxLevel[0] < level) {
			System.out.print(node.data + " ");
			maxLevel[0] = level;
		}

		rightViewUtil(node.right, level + 1, maxLevel);
		rightViewUtil(node.left, level + 1, maxLevel);
	}
}

public class BinaryTreeView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Example Input
		// Tree:
		// 1
		// / \
		// 2 3
		// \ \
		// 5 4
		//
		// Left View = 1 2 5
		// Right View = 1 3 4

		Tree tree = new Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(4);

		System.out.print("Left View  : ");
		tree.leftView(tree.root);

		System.out.print("Right View : ");
		tree.rightView(tree.root);
	}
}
