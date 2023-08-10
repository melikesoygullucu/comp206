
public class BinarySearchTree {
	public class Node {
		// Each node has at most two children which is left and right
		int value;
		Node left, right;

		// Constructor to initialize the node with a value and no children
		public Node(int value) { 
			this.value = value;
			left = right = null;
		}
	}

	Node root;

	// Constructor to initialize an empty binary search tree
	public BinarySearchTree() {
		root = null;
	}

	// Method to insert a new value into the binary search tree
	public void insert(int val) {
		root = _insert(root, val);
	}

	// Helper method to recursively insert a new value into the binary search tree
	private Node _insert(Node node, int value) {
		// If the node is null, create a new node with the given value
		if (node == null) {
			node = new Node(value);
			return node;
		}
		// If the value is less than the node's value, insert it in the left subtree
		if (value < node.value) {
			node.left = _insert(node.left, value);
		}
		// If the value is greater than the node's value, insert it in the right subtree
		else if (value > node.value) {	
			node.right = _insert(node.right, value);
		}
		return node;
	}
	// Method to delete a value from the binary search tree
	public void delete(int val) {
		root = _delete(root, val);
	}
	// Helper method to recursively delete a value from the binary search tree
	private Node _delete(Node node, int value) {
		// If the node is null, return null
		if (node == null) {
			return node;
		}
		// If the value is less than the node's value, delete it from the left subtree
		if (value < node.value) {
			node.left = _delete(node.left, value);
		} 
		// If the value is greater than the node's value, delete it from the right subtree
		else if (value > node.value) {
			node.right = _delete(node.right, value);
		} 
		// If the value is equal to the node's value, delete the node
		else {
			// If the node has no left child, replace it with its right child
			if (node.left == null) {
				return node.right;
			} 
			// If the node has no right child, replace it with its left child
			else if (node.right == null) {
				return node.left;
			}
			// If the node has two children, replace it with its in-order successor (the smallest node in its right subtree)
			Node temp = _minValueNode(node.right);
			node.value = temp.value;
			node.right = _delete(node.right, temp.value);
		}
		return node;
	}
	 // Method to find the node with the smallest value in a subtree
	private Node _minValueNode(Node node) {
		Node current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	public void inorderTraversal() {
		_inorderTraversal(root);
	}
	// Helper method to recursively print the values of the nodes in the binary search tree in-order
	private void _inorderTraversal(Node node) {
		if (node != null) {
			_inorderTraversal(node.left);
			System.out.print(node.value + " ");
			_inorderTraversal(node.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree1 = new BinarySearchTree();
		tree1.insert(8);
		tree1.insert(3);
		tree1.insert(7);
		tree1.insert(2);
		tree1.insert(5);
		tree1.insert(4);
		tree1.insert(6);
		tree1.inorderTraversal();// 2 3 4 5 6 7 8 
		System.out.println(); 
		tree1.delete(7);
		tree1.delete(3);
		tree1.delete(1); // there is no such an element
		tree1.inorderTraversal(); // 2 4 5 6 8 

	}

}
