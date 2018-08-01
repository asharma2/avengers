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

		@Override
		public String toString() {
			return "Node: " + data;
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
		System.out.println();
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

	class MaxLevel {
		int max;

		public MaxLevel setMax(int max) {
			this.max = max;
			return this;
		}
	}

	public void printLeftView() {
		printLeftView(root, 1, new MaxLevel().setMax(0));
		System.out.println();
	}

	private void printLeftView(Node node, int level, MaxLevel maxLevel) {
		if (node == null)
			return;

		if (level > maxLevel.max) {
			maxLevel.max = level;
			System.out.print(node.data + " ");
		}

		printLeftView(node.left, level + 1, maxLevel);
		printLeftView(node.right, level + 1, maxLevel);
	}

	public boolean isBinaryTree() {
		return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBst(Node node, int minValue, int maxValue) {
		if (node == null)
			return true;
		int data = node.data;
		if (data < minValue && data > maxValue)
			return false;
		return isBst(node.left, minValue, node.data - 1) && isBst(node.right, node.data + 1, maxValue);
	}

	public boolean isMirror(Node that) {
		return isMirror(root, that);
	}

	public boolean isIdentical(Node that) {
		return isIdentical(root, that);
	}

	class NodeInfo {
		Node node;
		int max;
		int min;
		int size;
		int ans;
		boolean bst;

		public Node getNode() {
			return node;
		}

		public NodeInfo setNode(Node node) {
			this.node = node;
			return this;
		}

		public int getMax() {
			return max;
		}

		public NodeInfo setMax(int max) {
			this.max = max;
			return this;
		}

		public int getMin() {
			return min;
		}

		public NodeInfo setMin(int min) {
			this.min = min;
			return this;
		}

		public int getSize() {
			return size;
		}

		public NodeInfo setSize(int size) {
			this.size = size;
			return this;
		}

		public boolean isBst() {
			return bst;
		}

		public NodeInfo setBst(boolean bst) {
			this.bst = bst;
			return this;
		}

		public int getAns() {
			return ans;
		}

		public NodeInfo setAns(int ans) {
			this.ans = ans;
			return this;
		}

		@Override
		public String toString() {
			return "NodeInfo [node=" + node + ", max=" + max + ", min=" + min + ", size=" + size + ", ans=" + ans + ", bst="
			        + bst + "]";
		}

	}

	public int largestBst() {
		NodeInfo ni = largestBst(root);
		return ni.ans;
	}

	private NodeInfo largestBst(Node node) {
		if (node == null)
			return new NodeInfo().setBst(true).setMin(Integer.MAX_VALUE).setMax(Integer.MIN_VALUE).setSize(0);

		if (node.left == null && node.right == null)
			return new NodeInfo().setBst(true).setMin(node.data).setMax(node.data).setSize(1);

		NodeInfo left = largestBst(node.left);
		NodeInfo right = largestBst(node.right);

		NodeInfo ret = new NodeInfo().setSize(1 + left.size + right.size);

		if (left.bst && right.bst && left.max < node.data && node.data < right.min) {
			ret.min = Math.min(left.min, Math.min(right.min, node.data));
			ret.max = Math.max(right.max, Math.max(left.max, node.data));
			ret.node = node;
			ret.bst = true;
			return ret;
		}

		ret.ans = Math.max(left.size, right.size);
		ret.bst = false;
		return ret;
	}

	private boolean isIdentical(Node _this, Node _that) {
		if (_this == null && _that == null)
			return true;
		if (_this != null && _that != null && _this.data == _that.data)
			return isIdentical(_this.left, _that.left) && isMirror(_this.right, _that.right);
		return false;
	}

	private boolean isMirror(Node _this, Node _that) {
		if (_this == null && _that == null)
			return true;
		if (_this != null && _that != null && _this.data == _that.data)
			return isMirror(_this.left, _that.right) && isMirror(_this.right, _that.left);
		return false;
	}

}
