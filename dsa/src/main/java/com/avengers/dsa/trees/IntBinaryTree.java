package com.avengers.dsa.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class IntBinaryTree implements BinaryTree<Integer> {

	protected Node root;
	protected Node head;

	/**
	 * The {@link MaxLevel} will hold the max level at each level
	 * 
	 * @author atul_sharma
	 *
	 */
	class MaxLevel {
		int max;

		public MaxLevel setMax(int max) {
			this.max = max;
			return this;
		}
	}

	/**
	 * The {@link NodeInfo} will hold the max and min value of the descendants and
	 * whether its bst or not
	 * 
	 * @author atul_sharma
	 *
	 */
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
			return "NodeInfo [node=" + node + ", max=" + max + ", min=" + min + ", size=" + size + ", ans=" + ans
					+ ", bst=" + bst + "]";
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

	public boolean isMirror(Node that) {
		return areNodeMirror(root, that);
	}

	public boolean isIdentical(Node that) {
		return areNodeIdentical(root, that);
	}

	@Override
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
		return isBst(node.left, minValue, data - 1) && isBst(node.right, data + 1, maxValue);
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

		NodeInfo result = new NodeInfo().setSize(1 + left.size + right.size);

		if (left.bst && right.bst && left.max < node.data && node.data < right.min) {
			result.min = Math.min(left.min, Math.min(right.min, node.data));
			result.max = Math.max(right.max, Math.max(left.max, node.data));
			result.node = node;
			result.bst = true;
			return result;
		}

		result.ans = Math.max(left.size, right.size);
		result.bst = false;
		return result;
	}

	@Override
	public int height() {
		return height(root);
	}

	@Override
	public int diameter() {
		return diameter(root);
	}

	@Override
	public int countLeaf() {
		return countLeaf(root);
	}

	@Override
	public boolean isHeightBalanced() {
		return isHeightBalanced(root);
	}

	@Override
	public void mirror() throws Exception {
		root = mirror(root);
	}

	@Override
	public int lowestCommonAncestor(int a, int b) {
		Node lowest = lowestCommonAncestorInBst(root, a, b);
		return lowest != null ? lowest.data : lowestCommonAncestor(root, a, b);
	}

	private int lowestCommonAncestor(Node node, int a, int b) {
		if (node == null)
			return -1;
		List<Integer> path1 = new LinkedList<>();
		List<Integer> path2 = new LinkedList<>();
		if (!findPath(node, a, path1) || !findPath(node, b, path2)) {
			System.out.println((path1.size() > 0) ? "a is present" : "b is missing");
			System.out.println((path2.size() > 0) ? "b is present" : "a is missing");
			return -1;
		}
		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (!path1.get(i).equals(path2.get(i))) {
				break;
			}
		}
		return path1.get(i - 1);
	}

	private boolean findPath(Node root, int n, List<Integer> path) {
		if (root == null) {
			return false;
		}
		path.add(root.data);
		if (root.data == n) {
			return true;
		}
		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}

	private Node lowestCommonAncestorInBst(Node node, int a, int b) {
		if (node == null)
			return null;

		if (node.data > a && node.data > b)
			return lowestCommonAncestorInBst(node.left, a, b);

		if (node.data < a && node.data < b)
			return lowestCommonAncestorInBst(node.right, a, b);

		return node;
	}

	@Override
	public int longestConsecutiveSequence() {
		MaxSequence ms = new MaxSequence();
		longestConsecutiveSequence(root, root.data, ms);
		return ms.max;
	}

	class MaxSequence {
		int max;
		int count;

		public int getMax() {
			return max;
		}

		public MaxSequence setMax(int max) {
			this.max = max;
			return this;
		}

		public int getCount() {
			return count;
		}

		public MaxSequence setCount(int count) {
			this.count = count;
			return this;
		}

	}

	private void longestConsecutiveSequence(Node node, int expectedData, MaxSequence ms) {
		if (node == null)
			return;

		if (node.data == expectedData) {
			ms.count++;
			if (ms.count > ms.max) {
				ms.max = ms.count;
			}
		} else {
			ms.count = 1;
		}
		longestConsecutiveSequence(node.left, node.data + 1, ms);
		longestConsecutiveSequence(node.right, node.data + 1, ms);
	}

	@Override
	public void printBottomView() {
		printBottomView(root);
	}

	private void printBottomView(Node node) {
		if (node == null)
			return;

		int hd = 0;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Node> queue = new LinkedList<Node>();

		node.hd = hd;
		queue.add(node);

		while (!queue.isEmpty()) {

			Node x = queue.remove();
			hd = x.hd;
			map.put(hd, x.data);

			if (x.left != null) {
				x.left.hd = hd - 1;
				queue.add(x.left);
			}

			if (x.right != null) {
				x.right.hd = hd + 1;
				queue.add(x.right);
			}
		}

		Set<Entry<Integer, Integer>> set = map.entrySet();

		Iterator<Entry<Integer, Integer>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue() + " ");
		}
	}

	@Override
	public void connectSameLevel() {
		Node node = root;
		node.next = null;
		connectSameLevel(node);
	}

	private void connectSameLevel(Node node) {
		if (node == null)
			return;

		if (node.left != null)
			node.left.next = node.right;

		if (node.right != null)
			node.right.next = (node.next != null) ? node.next.left : null;

		connectSameLevel(node.left);
		connectSameLevel(node.right);
	}

	@Override
	public void convertToDLL() {
		convertToDLL(root);
	}

	protected static Node prev;

	private void convertToDLL(Node node) {
		if (node == null)
			return;
		convertToDLL(node.left);
		if (prev == null)
			head = node;
		else {
			node.left = prev;
			prev.right = node;
		}
		prev = node;
		convertToDLL(node.right);
	}

	@Override
	public int sumOfCousin(int data) {
		return sumOfCousin(root, data);
	}

	private int sumOfCousin(Node node, int data) {
		if (node == null)
			return -1;
		if (node.data == data)
			return -1;
		int cSum = 0;
		int size;
		boolean found = false;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			if (found)
				return cSum;
			size = queue.size();
			cSum = 0;
			while (size > 0) {
				Node x = queue.poll();
				if ((x.left != null && x.left.data == data) || (x.right != null && x.right.data == data)) {
					found = true;
				} else {
					if (x.left != null) {
						cSum += node.left.data;
						queue.add(x.left);
					}
					if (x.right != null) {
						cSum += node.right.data;
						queue.add(x.right);
					}
				}
				size--;
			}
		}

		return -1;
	}
	
	
}
