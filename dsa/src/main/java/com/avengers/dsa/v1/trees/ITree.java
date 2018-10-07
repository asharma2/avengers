package com.avengers.dsa.v1.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public interface ITree<T extends Comparable<T>> {

	class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;

		public Node(T data) {
			this.data = data;
		}

		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}

	enum Order {
		None, Recursion, NoRecursion
	}

	enum Traversal {
		PreOrder, PostOrder, InOrder
	}

	void insert(T item);

	void delete(T item);

	boolean exists(T item);

	boolean isHeightBalanced();

	boolean isMirror();

	int countLeaf();

	int height();

	int diameter();

	int largestBst();

	int countSpecialDigit();

	int longestConsecutiveSequence();

	int lowestCommonAncestor(int a, int b);

	Iterator<T> preOrder(Order order);

	Iterator<T> postOrder(Order order);

	Iterator<T> inOrder(Order order);

	Iterator<T> levelOrder();

	Iterator<T> zigzagOrder();

	Iterator<T> bottomView();

	Iterator<T> spiralOrder();

	boolean isSumExists(T sum);

	default Iterator<T> iterator(Node<T> node, Order order, Traversal traversal) {
		switch (order) {
		case Recursion:
			return recursionTraversal(node, traversal);
		case NoRecursion:
			return nonRecursiveTraversal(node, traversal);
		case None:
		}
		return null;
	}

	default Iterator<T> nonRecursiveTraversal(Node<T> node, Traversal traversal) {
		switch (traversal) {
		case InOrder:
			return inOrderTraversalWithoutRecursion(node);
		case PreOrder:
			return preOrderTraversalWithoutRecursion(node);
		case PostOrder:
			return postOrderTraversalWithoutRecursion(node);
		}
		return null;
	}

	default Iterator<T> postOrderTraversalWithoutRecursion(Node<T> node) {
		Stack<Node<T>> stack1 = new Stack<>();
		Stack<Node<T>> stack2 = new Stack<>();
		List<T> list = new LinkedList<>();
		stack1.push(node);
		while (!stack1.isEmpty()) {
			Node<T> x = stack1.pop();
			/**
			 * Put in stack2
			 */
			stack2.push(x);
			/**
			 * Push in stack1 if left is there
			 */
			if (x.left != null) {
				stack1.push(x.left);
			}
			/**
			 * Push in stack1 if right is there
			 */
			if (x.right != null) {
				stack1.push(x.right);
			}
		}
		while (!stack2.isEmpty()) {
			list.add(stack2.pop().data);
		}
		return list.iterator();
	}

	default Iterator<T> preOrderTraversalWithoutRecursion(Node<T> node) {
		Stack<Node<T>> stack = new Stack<>();
		stack.push(node);
		List<T> list = new LinkedList<>();
		while (!stack.isEmpty()) {
			/**
			 * Get the root data
			 */
			Node<T> x = stack.pop();
			list.add(x.data);
			/**
			 * First push right node
			 */
			if (x.right != null) {
				stack.push(x.right);
			}
			/**
			 * Then push left node, so it will be at top of stack
			 */
			if (x.left != null) {
				stack.push(x.left);
			}
		}
		return list.iterator();
	}

	default Iterator<T> inOrderTraversalWithoutRecursion(Node<T> node) {
		Stack<Node<T>> stack = new Stack<>();
		Node<T> current = node;
		List<T> list = new LinkedList<>();
		while (!stack.isEmpty() || current != null) {
			/**
			 * Push all the left node
			 */
			while (current != null) {
				stack.push(current.left);
				current = current.left;
			}
			/**
			 * Pop last element and print
			 */
			Node<T> x = stack.pop();
			list.add(x.data);
			/**
			 * Check if the last element has right
			 */
			if (x.right != null) {
				current = x.right;
			}
		}
		return list.iterator();
	}

	default Iterator<T> recursionTraversal(Node<T> node, Traversal traversal) {
		List<T> list = new LinkedList<>();
		switch (traversal) {
		case InOrder:
			inOrderRecursion(node, list);
			return list.iterator();
		case PreOrder:
			preOrderRecursion(node, list);
			return list.iterator();
		case PostOrder:
			postOrderRecursion(node, list);
			return list.iterator();
		}
		return null;
	}

	default void postOrderRecursion(Node<T> node, List<T> list) {
		if (node == null)
			return;
		preOrderRecursion(node.left, list);
		preOrderRecursion(node.right, list);
		list.add(node.data);
	}

	default void preOrderRecursion(Node<T> node, List<T> list) {
		if (node == null)
			return;
		list.add(node.data);
		preOrderRecursion(node.left, list);
		preOrderRecursion(node.right, list);
	}

	default void inOrderRecursion(Node<T> node, List<T> list) {
		if (node == null)
			return;
		inOrderRecursion(node.left, list);
		list.add(node.data);
		inOrderRecursion(node.right, list);
	}

	default boolean areIdentical(Node<T> a, Node<T> b) {
		if (a == null && b == null)
			return true;
		if ((a != null && b != null && a.data.compareTo(a.data) == 0))
			return true;
		return areIdentical(a.left, b.left) && areIdentical(a.right, b.right);
	}

	default boolean areMirror(Node<T> a, Node<T> b) {
		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;
		return (a.data.compareTo(a.data) == 0) && areMirror(a.left, b.right) && areMirror(a.right, b.left);
	}

	default int height(Node<Integer> node) {
		if (node == null)
			return 0;
		int lHght = height(node.left);
		int rHght = height(node.right);
		return Math.max(lHght, rHght) + 1;
	}

	static <T> List<T> convertIteratorToList(Iterator<T> iterator) {
		List<T> itrs = new LinkedList<>();
		while (iterator.hasNext()) {
			itrs.add(iterator.next());
		}
		return itrs;
	}

}
