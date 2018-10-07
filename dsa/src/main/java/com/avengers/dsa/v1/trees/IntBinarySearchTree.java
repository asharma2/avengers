package com.avengers.dsa.v1.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IntBinarySearchTree implements ITree<Integer> {

	protected Node<Integer> root;
	protected Node<Integer> dllRoot;

	@Override
	public void insert(Integer item) {
		root = insert(root, item);
	}

	private Node<Integer> insert(Node<Integer> node, Integer item) {
		if (node == null)
			return new Node<Integer>(item);
		if (item < node.data)
			node.left = insert(node.left, item);
		else if (item > node.data)
			node.right = insert(node.right, item);
		return node;
	}

	@Override
	public void delete(Integer item) {
		root = delete(root, item);
	}

	private Node<Integer> delete(Node<Integer> node, Integer data) {
		if (node == null)
			return node;
		if (data < node.data) {
			node.left = delete(node.left, data);
		} else if (data > node.data) {
			node.right = delete(node.right, data);
		} else {
			if (node.left == null)
				return node.right;
			if (node.right == null)
				return node.left;
			/**
			 * Fetch the minimum value of the right node
			 */
			node.data = minValue(node.right);
			/**
			 * Remove the right node's minimum value
			 */
			node.right = delete(node.right, node.data);
		}
		return node;
	}

	private Integer minValue(Node<Integer> node) {
		int minVal = node.data;
		while (node.left != null) {
			minVal = node.left.data;
			node = node.left;
		}
		return minVal;
	}

	@Override
	public boolean exists(Integer item) {
		return exists(root, item) != null;
	}

	private Node<Integer> exists(Node<Integer> node, Integer item) {
		if (node == null)
			return null;
		if (node.data == item)
			return node;
		if (item > node.data)
			return exists(node.right, item);
		if (item < node.data)
			return exists(node.left, item);
		return null;
	}

	@Override
	public boolean isHeightBalanced() {
		return isHeightBalanced(root);
	}

	class Height {
		int height;
	}

	/**
	 * O(n)
	 * 
	 * @param node
	 * @param height
	 * @return
	 */
	protected boolean isHeightBalanced(Node<Integer> node, Height height) {
		if (node == null) {
			height.height = 0;
			return true;
		}
		Height lhgt = new Height();
		Height rhgt = new Height();
		boolean lBalanced = isHeightBalanced(node.left, lhgt);
		boolean rBalanced = isHeightBalanced(node.right, rhgt);
		height.height = Math.max(lhgt.height, rhgt.height);
		if (Math.abs(lhgt.height - rhgt.height) >= 2)
			return false;
		return lBalanced && rBalanced;
	}

	/**
	 * O(n*n)
	 * 
	 * @param node
	 * @return
	 */
	protected boolean isHeightBalanced(Node<Integer> node) {
		if (node == null)
			return true;
		int lHght = height(node.left);
		int rHght = height(node.right);
		return Math.abs(lHght - rHght) <= 1 && isHeightBalanced(node.left) && isHeightBalanced(node.right);
	}

	@Override
	public boolean isMirror() {
		return false;
	}

	@Override
	public int countLeaf() {
		return countLeaf(root);
	}

	private int countLeaf(Node<Integer> node) {
		if (node == null)
			return 1;
		return countLeaf(node.left) + countLeaf(node.right);
	}

	@Override
	public int height() {
		return height(root);
	}

	@Override
	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node<Integer> node) {
		if (node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		int lDiameter = diameter(node.left);
		int rDiameter = diameter(node.left);
		return Math.max(lheight + rheight + 1, Math.max(lDiameter, rDiameter));
	}

	@Override
	public int largestBst() {
		return 0;
	}

	@Override
	public int countSpecialDigit() {
		return 0;
	}

	@Override
	public int longestConsecutiveSequence() {
		return 0;
	}

	@Override
	public int lowestCommonAncestor(int a, int b) {
		return 0;
	}

	@Override
	public Iterator<Integer> preOrder(Order order) {
		return recursionTraversal(root, Traversal.PreOrder);
	}

	@Override
	public Iterator<Integer> postOrder(Order order) {
		return recursionTraversal(root, Traversal.PostOrder);
	}

	@Override
	public Iterator<Integer> inOrder(Order order) {
		return recursionTraversal(root, Traversal.InOrder);
	}

	@Override
	public Iterator<Integer> levelOrder() {
		return null;
	}

	@Override
	public Iterator<Integer> zigzagOrder() {
		Node<Integer> x = root;
		Stack<Node<Integer>> currentLevel = new Stack<>();
		Stack<Node<Integer>> nextLevel = new Stack<>();
		currentLevel.push(x);

		boolean leftToRight = true;
		while (!currentLevel.isEmpty()) {
			x = currentLevel.pop();
			if (leftToRight) {
				if (x.left != null)
					nextLevel.push(x.left);
				if (x.right != null)
					nextLevel.push(x.right);
			} else {
				if (x.right != null)
					nextLevel.push(x.right);
				if (x.right != null)
					nextLevel.push(x.right);
			}

			if (currentLevel.isEmpty()) {
				Stack<Node<Integer>> t = nextLevel;
				nextLevel = currentLevel;
				currentLevel = t;
				leftToRight = !leftToRight;
			}
		}
		return null;
	}

	@Override
	public Iterator<Integer> bottomView() {
		return bottomView(root);
	}

	private Iterator<Integer> bottomView(Node<Integer> node) {
		List<Integer> list = new LinkedList<>();
		bottomView(node, list);
		return list.iterator();
	}

	private void bottomView(Node<Integer> node, List<Integer> list) {
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			list.add(node.data);

		bottomView(node.left, list);
		bottomView(node.right, list);
	}

	@Override
	public boolean isSumExists(Integer sum) {
		Stack<Node<Integer>> leftStack = new Stack<>();
		Stack<Node<Integer>> rightStack = new Stack<>();
		/**
		 * Push all left elements to the left stack
		 */
		Node<Integer> x = root;
		while (x != null) {
			leftStack.push(x);
			x = x.left;
		}
		/**
		 * Push all elements to the right stack
		 */
		x = root;
		while (x != null) {
			rightStack.push(x);
			x = x.right;
		}

		while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
			Node<Integer> left = leftStack.peek();
			Node<Integer> right = rightStack.peek();
			int s = left.data + right.data;
			if (s == sum) {
				return true;
			} else if (s > sum) {
				removeNode(rightStack, false);
				if (rightStack.peek() == left)
					return false;
			} else if (s < sum) {
				removeNode(leftStack, true);
				if (leftStack.peek() == right)
					return false;
			}
		}
		return false;
	}

	private void removeNode(Stack<Node<Integer>> stack, boolean leftToRight) {
		Node<Integer> x = stack.pop();
		if (leftToRight) {
			x = x.right;
			while (x != null) {
				stack.push(x);
				x = x.right;
			}
		} else {
			x = x.left;
			while (x != null) {
				stack.push(x);
				x = x.left;
			}
		}
	}

	@Override
	public Iterator<Integer> spiralOrder() {
		List<Integer> spirals = new LinkedList<>();
		int height = height(root);
		boolean ltr = true;
		for (int i = 1; i <= height; i++) {
			printLevel(root, spirals, i, ltr);
			ltr = !ltr;
		}
		return spirals.iterator();
	}

	private void printLevel(Node<Integer> node, List<Integer> spirals, int level, boolean ltr) {
		if (node == null)
			return;
		if (level == 1) {
			spirals.add(node.data);
		} else if (level > 1) {
			if (ltr) {
				printLevel(node.left, spirals, level - 1, ltr);
				printLevel(node.right, spirals, level - 1, ltr);
			} else {
				printLevel(node.right, spirals, level - 1, ltr);
				printLevel(node.left, spirals, level - 1, ltr);
			}
		}
	}

	class Sum {
		int sum = 0;
	}

	public void sumOfLowestBinaryTree() throws Exception {
		Node<Integer> x = root;
		Sum s = new Sum();
		sumOfLowestBinaryTree(x, s);
	}

	private void sumOfLowestBinaryTree(Node<Integer> x, Sum s) {
		if (x == null)
			return;
		sumOfLowestBinaryTree(x.left, s);
		s.sum = s.sum + x.data;
		x.data = s.sum;
		sumOfLowestBinaryTree(x.right, s);
	}

	class Count {
		int count = 0;
	}

	class Index {
		int idx = 0;
	}

	public boolean longestSequence(int[] arr) {
		int n = arr.length;
		Index idx = new Index();
		longestSequence(arr, new Index(), root);
		return idx.idx == n;
	}

	private void longestSequence(int[] arr, Index idx, Node<Integer> node) {
		if (node == null)
			return;
		longestSequence(arr, idx, node.left);
		if (arr[idx.idx] == node.data)
			idx.idx++;
		longestSequence(arr, idx, node.right);
	}

	public boolean hasDeadEnd() {
		return hashDeadEnd(root, 1, Integer.MAX_VALUE);
	}

	private boolean hashDeadEnd(Node<Integer> node, int min, int max) {
		if (node == null)
			return false;
		if (min == max)
			return true;
		return hashDeadEnd(node.left, min, node.data - 1) || hashDeadEnd(node.right, node.data + 1, max);
	}

	class NodeInfo {
		int length;
		boolean bst;
		int max;
		int min;
		int ans;

		public int getLength() {
			return length;
		}

		public NodeInfo setLength(int length) {
			this.length = length;
			return this;
		}

		public boolean isBst() {
			return bst;
		}

		public NodeInfo setBst(boolean bst) {
			this.bst = bst;
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

		public int getAns() {
			return ans;
		}

		public NodeInfo setAns(int ans) {
			this.ans = ans;
			return this;
		}

	}

	public int largestLengthBst() {
		NodeInfo nodeInfo = largestLengthBst(root);
		return nodeInfo.ans;
	}

	private NodeInfo largestLengthBst(Node<Integer> node) {
		if (node == null)
			return new NodeInfo().setBst(true);
		if (node.left == null && node.right == null)
			return new NodeInfo().setBst(true).setLength(1).setMax(node.data).setMin(node.data);
		NodeInfo infoLeft = largestLengthBst(node.left);
		NodeInfo infoRight = largestLengthBst(node.right);
		NodeInfo x = new NodeInfo().setLength(infoLeft.length + infoRight.length + 1);
		if (infoLeft.bst && infoRight.bst && infoLeft.max < node.data && infoRight.min > node.data) {
			x.min = Math.min(infoLeft.min, Math.min(infoRight.min, node.data));
			x.max = Math.max(infoLeft.max, Math.min(infoRight.max, node.data));
			x.bst = true;
			x.ans = x.length;
			return x;
		}
		x.bst = false;
		x.ans = Math.max(infoLeft.ans, infoRight.ans);
		return x;
	}

	public int countInRange(int min, int max) {
		Count c = new Count();
		countInRange(root, min, max, c);
		return c.count;
	}

	private void countInRange(Node<Integer> node, int min, int max, Count c) {
		if (node == null)
			return;
		countInRange(node.left, min, max, c);
		if (inRange(node, min, max)) {
			c.count++;
		}
		countInRange(node.right, min, max, c);
	}

	private boolean inRange(Node<Integer> node, int min, int max) {
		return node.data >= min && node.data <= max;
	}

	public void deleteLeafNode() {
		root = deleteLeafNode(root);
	}

	private Node<Integer> deleteLeafNode(Node<Integer> node) {
		if (node == null)
			return null;
		if (node.left == null && node.right == null)
			return null;
		node.left = deleteLeafNode(node.left);
		node.right = deleteLeafNode(node.right);
		return node;
	}

}
