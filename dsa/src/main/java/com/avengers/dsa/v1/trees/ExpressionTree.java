package com.avengers.dsa.v1.trees;

import java.util.Stack;

public class ExpressionTree {

	Stack<Node> stack = new Stack<>();
	Node root;

	class Node {
		char value;
		Node left, right;

		public Node(char value) {
			this.value = value;
		}

	}

	boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '^' || ch == '/';
	}

	public void inOrder() {
		inOrder(root);
	}

	protected void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}

	public void insert(char ch) {
		if (!isOperator(ch)) {
			stack.push(new Node(ch));
		} else {
			Node x = new Node(ch);
			Node a = stack.pop();
			Node b = stack.pop();
			x.right = a;
			x.left = b;
			stack.push(x);
		}
		root = stack.peek();
	}

}
