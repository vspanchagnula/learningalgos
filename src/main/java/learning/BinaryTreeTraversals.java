package learning;

public class BinaryTreeTraversals {
	
	void inorder(Node node){
		if(null == node) {
			return;
		}
		inorder(node.left);
		System.out.println(node.data);
		inorder(node.right);
		
	}
	
	 public static void main(String[] args) {
		BinaryTreeTraversals binaryTreeTraversals = new BinaryTreeTraversals();
		 Node binaryTree = populateBinaryTreeData();
		binaryTreeTraversals.inorder(binaryTree);
	}

	private static Node populateBinaryTreeData() {
		Node binaryTree = new Node(40);
		 binaryTree.left = new Node(20);
		 binaryTree.left.left = new Node(10);
		 binaryTree.left.left.left = new Node(5);

		 binaryTree.left.right = new Node(30);
		 binaryTree.right = new Node(50);
		 binaryTree.right.right = new Node(60);
		 binaryTree.left.right.left = new Node(67);
		 binaryTree.left.right.right = new Node(78);
		return binaryTree;
	}

}

class Node{
	Node left;
	Node right;
	int data;
	public Node(int data) {
		this.data = data;
	}
	public Node() {
	}
}
