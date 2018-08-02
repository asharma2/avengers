package com.avengers.dsa.trees;

public class IntBinarySearchTree extends IntBinaryTree {

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node node) {
		Node x = node;
		if (x == null)
			return 0;
		return 1 + size(node.left) + size(node.right);
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
		root = insert(root, data);
		return data;
	}

	private Node insert(Node node, Integer data) {
		Node x = node;
		if (x == null) {
			return new Node(data);
		}
		if (data <= x.data) {
			x.left = insert(x.left, data);
		} else {
			x.right = insert(x.right, data);
		}
		return x;
	}

	@Override
	public void delete(Integer data) throws Exception {
		root = delete(root, data);
	}

	private Node delete(Node node, Integer data) {
		Node x = node;
		if (x != null) {
			if (x.data == data) {
				if (x.left == null && x.right == null) {
					return null;
				} else if (x.left == null) {
					return x.right;
				} else if (x.right == null) {
					return x.left;
				} else {
					Node lt = x.left, rt = x.right;
					if (lt == null && rt == null)
						return null;
					if (lt == null)
						return rt;
					if (rt == null)
						return lt;
					/**
					 * Find the min value in right sub tree
					 */
					Node min = rt, parent = rt;
					while (min.left != null) {
						min = min.left;
					}
					min.left = lt;
					parent.left = min.right;
					min.right = parent;
					return min;
				}
			} else if (data < x.data) {
				Node a = delete(x.left, data);
				x.left = a;
			} else {
				Node a = delete(x.right, data);
				x.right = a;
			}
		}
		return x;
	}

	@Override
	public boolean search(Integer data) throws Exception {
		return search(root, data);
	}

	private boolean search(Node node, Integer data) {
		Node x = node;
		if (x == null)
			return false;
		if (data == x.data)
			return true;
		return (data < x.data) ? search(x.left, data) : search(x.right, data);
	}

}
