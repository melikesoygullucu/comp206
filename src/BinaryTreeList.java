// Class containing left and right child
// of current node and key value
class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class BinaryTreeList {
	Node root;

	public BinaryTreeList() {
		root = null;
	}

	public void add(int key) {
		root = addS(root, key);
	}

	public Node addS(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key) {
			root.left = addS(root.left, key);
		} else if (key > root.key) {
			root.right = addS(root.right, key);
		}
		return root;
	}

	public void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.key + " ");
			inorderTraversal(root.right);
		}
	}

	public static void main(String[] args) {
		BinaryTreeList list = new BinaryTreeList();

		list.add(67);
		list.add(45);
		list.add(37);
		list.add(15);
		list.add(94);
		list.add(78);
		list.add(28);

		list.inorderTraversal(list.root);
	}
}
