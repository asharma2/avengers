package com.avengers.dsa.v1.trees;

import java.util.Iterator;

public class IntBinaryTree implements ITree<Integer> {

	protected Node<Integer> root;

	@Override
	public void insert(Integer item) {
		throw new UnsupportedOperationException("No predefined insertion order for binary tree");
	}

	@Override
	public void delete(Integer item) {
		throw new UnsupportedOperationException("No predefined deletion order for binary tree");
	}

	@Override
	public boolean exists(Integer item) {
		return false;
	}

	@Override
	public boolean isHeightBalanced() {
		return isHeightBalanced(root);
	}

	private boolean isHeightBalanced(Node<Integer> node) {
		if (node == null)
			return true;
		int lHeight = height(node.left);
		int rHeight = height(node.right);
		if (Math.abs(lHeight - rHeight) <= 1 && isHeightBalanced(node.left) && isHeightBalanced(node.right)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isMirror() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int countLeaf() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int diameter() {
		return 0;
	}

	@Override
	public int largestBst() {
		return 0;
	}

	@Override
	public int countSpecialDigit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int longestConsecutiveSequence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lowestCommonAncestor(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> preOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> postOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> inOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> levelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> zigzagOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> bottomView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSumExists(Integer sum) {
		return false;
	}

	@Override
	public Iterator<Integer> spiralOrder() {
		return null;
	}

}
