package leetcodeZoho2;

//TreeNode class definition
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

//Solution class
public class BinaryTree_LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		}

		return left != null ? left : right;
	}

	public static void main(String[] args) {
		// Example binary tree
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		// Nodes to find the LCA
		TreeNode p = root.left; // Node with value 5
		TreeNode q = root.left.right.right; // Node with value 4

		BinaryTree_LowestCommonAncestor sol = new BinaryTree_LowestCommonAncestor();
		TreeNode lca = sol.lowestCommonAncestor(root, p, q);

		System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "null"));

	}
}
