package leetcodeZoho7;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BoundaryTraversal {
    
    // Function to check if a node is a leaf
    private static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    // Add left boundary (excluding leaves)
    private static void addLeftBoundary(Node root, List<Integer> result) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) result.add(curr.data);
            curr = (curr.left != null) ? curr.left : curr.right;
        }
    }

    // Add leaf nodes
    private static void addLeaves(Node root, List<Integer> result) {
        if (root == null) return;
        if (isLeaf(root)) {
            result.add(root.data);
            return;
        }
        addLeaves(root.left, result);
        addLeaves(root.right, result);
    }

    // Add right boundary (excluding leaves, in reverse)
    private static void addRightBoundary(Node root, List<Integer> result) {
        Node curr = root.right;
        Stack<Integer> stack = new Stack<>();
        while (curr != null) {
            if (!isLeaf(curr)) stack.push(curr.data);
            curr = (curr.right != null) ? curr.right : curr.left;
        }
        while (!stack.isEmpty()) result.add(stack.pop());
    }

    // Main function to do boundary traversal
    public static List<Integer> boundaryTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        if (!isLeaf(root)) result.add(root.data);

        addLeftBoundary(root, result);
        addLeaves(root, result);
        addRightBoundary(root, result);

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> result = boundaryTraversal(root);
        System.out.println("Boundary Traversal:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
