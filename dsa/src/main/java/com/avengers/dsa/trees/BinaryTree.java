package com.avengers.dsa.trees;

public interface BinaryTree<T> extends ITree<T> {

	/**
	 * The {@link Node} class represent single node structure
	 * 
	 * @author atul_sharma
	 *
	 */
	public class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this(data, null, null);
		}

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node: " + data;
		}
	}

	default boolean areNodeIdentical(Node _this, Node _that) {
		if (_this == null && _that == null)
			return true;
		if (_this != null && _that != null && _this.data == _that.data)
			return areNodeIdentical(_this.left, _that.left) && areNodeMirror(_this.right, _that.right);
		return false;
	}

	default boolean areNodeMirror(Node _this, Node _that) {
		if (_this == null && _that == null)
			return true;
		if (_this != null && _that != null && _this.data == _that.data)
			return areNodeMirror(_this.left, _that.right) && areNodeMirror(_this.right, _that.left);
		return false;
	}

	default void levelOrderRecursive(Node node) {
		if (node == null)
			return;
		if (node.right == null && node.left == null)
			System.out.print(node.data + " ");
		levelOrderRecursive(node.left);
		levelOrderRecursive(node.right);
	}

	default void postOrderRecursive(Node node) {
		if (node == null)
			return;
		postOrderRecursive(node.left);
		postOrderRecursive(node.right);
		System.out.print(node.data + " ");
	}

	default void preOrderRecursive(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrderRecursive(node.left);
		preOrderRecursive(node.right);
	}

	default void inOrderRecursive(Node node) {
		if (node == null)
			return;
		inOrderRecursive(node.left);
		System.out.print(node.data + " ");
		inOrderRecursive(node.right);
	}

	default int height(Node node) {
		if (node == null)
			return 0;
		int left = height(node.left);
		int right = height(node.right);
		return Math.max(left, right) + 1;
	}

	default int countLeaf(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		return countLeaf(node.left) + countLeaf(node.right);
	}

	default int diameter(Node node) {
		if (node == null)
			return 0;

		int lheight = height(node.left);
		int rheight = height(node.right);

		int ldiameter = diameter(node.left);
		int rdiameter = diameter(node.right);

		int max = Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
		return max;
	}

	default boolean isHeightBalanced(Node node) {
		if (node == null)
			return true;
		int lheight = height(node.left);
		int rheight = height(node.right);
		if (Math.abs(lheight - rheight) <= 1 && isHeightBalanced(node.left) && isHeightBalanced(node.right)) {
			return true;
		}
		return false;
	}

	default Node mirror(Node node) {
		if (node == null)
			return null;

		Node left = mirror(node.left);
		Node right = mirror(node.right);

		node.left = right;
		node.right = left;

		return node;
	}

}
