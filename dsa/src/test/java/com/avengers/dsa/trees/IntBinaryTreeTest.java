package com.avengers.dsa.trees;

import org.junit.Test;

public class IntBinaryTreeTest {

	@Test
	public void intBinaryTree() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();
		ibt.root = ibt.new Node(100);
		ibt.root.left = ibt.new Node(50);
		
		ibt.root.left.left = ibt.new Node(25);
		ibt.root.left.right = ibt.new Node(75);
		
		ibt.root.left.left.left = ibt.new Node(12);
		ibt.root.left.left.right = ibt.new Node(24);
		
		ibt.root.left.left.left.left = ibt.new Node(6);
		ibt.root.left.left.left.right = ibt.new Node(14);
		
		
		ibt.root.right = ibt.new Node(150);
		
		ibt.root.right.left = ibt.new Node(125);
		ibt.root.right.right = ibt.new Node(175);
		
		ibt.root.right.right.left = ibt.new Node(112);
		ibt.root.right.right.right = ibt.new Node(124);
		
		
	}
}
