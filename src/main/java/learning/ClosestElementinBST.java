package learning;

// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

//1.  Idea is to start traversing the tree with iterative approach , as it reduces SC from O(n) to O(1)
// 2. Need to track which element is closer so need to maintain a counter at each iteration and compare with 
 // overall minDiff so far
 // 3. If target is less than node value go left, if greater  go right else break
// TC : O(logn) avg O(n) worst SC : O(1)
public class ClosestElementinBST {

	private static int findClosestValue(TreeNode node, int target) {
		TreeNode currentNode = node;
		int closestValue = currentNode.val;
		double minDiff = Double.MAX_VALUE;

		while (currentNode != null) {
			double currentDiff = Math.abs(target - currentNode.val);
			if (currentDiff < minDiff) {
				minDiff = currentDiff;
				closestValue = currentNode.val;
			}
			if (target < currentNode.val) {
				currentNode = currentNode.left;
			} else if (target > currentNode.val) {
				currentNode = currentNode.right;
			} else {
				break;
			}
		}
		return closestValue;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(9);
		node.left = new TreeNode(4);
		node.right = new TreeNode(17);

		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(6);
		node.left.right.left = new TreeNode(5);
		node.left.right.right = new TreeNode(7);

		node.right.right = new TreeNode(22);
		node.right.right.left = new TreeNode(20);

		System.out.println(findClosestValue(node, 18));
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}
