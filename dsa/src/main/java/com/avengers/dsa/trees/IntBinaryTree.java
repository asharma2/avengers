package com.avengers.dsa.trees;

public class IntBinaryTree implements ITree<Integer> {

	protected Node root;

	class Node {
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

	}

	@Override
	public int size() {
		return sizeInternal(root);
	}

	private int sizeInternal(Node node) {
		if (node == null)
			return 0;
		return sizeInternal(node.left) + sizeInternal(node.right) + 1;
	}

	@Override
	public int size(int level) {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public Integer insert(Integer data) throws Exception {
		throw new UnsupportedOperationException("No insertion order specified for binary tree");
	}

	@Override
	public void delete(Integer data) throws Exception {
		throw new UnsupportedOperationException("No deletion order specified for binary tree");
	}

	@Override
	public boolean search(Integer data) throws Exception {
		return search(root, data) != null;
	}

	private Node search(Node node, Integer data) {
		if (node == null)
			return null;
		if (node.data == data)
			return node;
		return findFirstOccurence(search(node.left, data), search(node.right, data));
	}

	private Node findFirstOccurence(Node left, Node right) {
		if (left == null && right == null)
			return null;
		if (left == null)
			return right;
		return left;
	}

	@Override
	public void print(Option option, Traversal traversal) {
		switch (option) {
		case Recursive:
			switch (traversal) {
			case InOrder:
				inOrderRecursive(root);
				break;
			case PreOrder:
				preOrderRecursive(root);
				break;
			case PostOrder:
				postOrderRecursive(root);
				break;
			case LevelOrder:
				levelOrderRecursive(root);
				break;
			}
			break;
		case NonRecursive:
			switch (traversal) {
			case InOrder:
				break;
			case PreOrder:
				break;
			case PostOrder:
				break;
			case LevelOrder:
				break;
			}
			break;
		}
	}

	private void levelOrderRecursive(Node node) {
		if (node == null)
			return;
		if (node.right == null && node.left == null)
			System.out.print(node.data + " ");
		levelOrderRecursive(node.left);
		levelOrderRecursive(node.right);
	}

	private void postOrderRecursive(Node node) {
		if (node == null)
			return;
		postOrderRecursive(node.left);
		postOrderRecursive(node.right);
		System.out.print(node.data + " ");
	}

	private void preOrderRecursive(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrderRecursive(node.left);
		preOrderRecursive(node.right);
	}

	private void inOrderRecursive(Node node) {
		if (node == null)
			return;
		inOrderRecursive(node.left);
		System.out.print(node.data + " ");
		inOrderRecursive(node.right);
	}

}
