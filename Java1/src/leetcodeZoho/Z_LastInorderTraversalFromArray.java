package leetcodeZoho;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
//Not touch
public class Z_LastInorderTraversalFromArray {
	// Function to construct a binary tree from an array
	public static TreeNode constructTree(int[] nums, int index) {
		if (index >= nums.length || nums[index] == -1) {
			return null;
		}

		TreeNode root = new TreeNode(nums[index]);
		root.left = constructTree(nums, 2 * index + 1);
		root.right = constructTree(nums, 2 * index + 2);
		return root;
	}

	// Function to perform inorder traversal of a binary tree
	public static void inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.val + " ");
			inorderTraversal(root.right);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 }; // Example array representing the binary tree

		TreeNode root = constructTree(nums, 0);
		System.out.print("Inorder traversal: ");
		inorderTraversal(root);
	}
}
