package leetcodeZoho3;

public class SumOfRootToLeaf {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val=val;
		}
	}

	public static void main(String[] args) {
		TreeNode tree=new TreeNode(5);
		tree.left=new TreeNode(6);
		tree.right=new TreeNode(3);
		tree.left.left=new TreeNode(2);
		tree.left.right=new TreeNode(6);
		tree.right.left=new TreeNode(8);
		
		System.out.println(findSumRoot(tree,0));
		
	}

	private static int findSumRoot(TreeNode tree,int currentSum) {
		if(tree==null)
			return 0;
		
		currentSum=currentSum*10+tree.val;
		
		if(tree.left==null && tree.right==null)
			return currentSum;
		
		int LeftSum=findSumRoot(tree.left,currentSum);
		int RightSum=findSumRoot(tree.right,currentSum);
		
		return LeftSum+RightSum;
	}
}
