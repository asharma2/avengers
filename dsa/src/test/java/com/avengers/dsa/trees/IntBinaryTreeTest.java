package com.avengers.dsa.trees;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import com.avengers.dsa.trees.ITree.Option;
import com.avengers.dsa.trees.ITree.Traversal;

public class IntBinaryTreeTest {

	@Test
	@Ignore
	public void leftView() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();
		ibt.root = ibt.new Node(12);
		ibt.root.left = ibt.new Node(10);
		ibt.root.right = ibt.new Node(30);
		ibt.root.right.left = ibt.new Node(25);
		ibt.root.right.right = ibt.new Node(40);

		ibt.printLeftView();

		IntBinaryTree ibt2 = new IntBinaryTree();
		ibt2.root = ibt2.new Node(1);
		ibt2.root.left = ibt2.new Node(2);
		ibt2.root.left.left = ibt2.new Node(4);
		ibt2.root.left.right = ibt2.new Node(5);
		ibt2.root.right = ibt2.new Node(3);
		ibt2.root.right.right = ibt2.new Node(6);

		ibt2.printLeftView();

		IntBinaryTree ibt3 = new IntBinaryTree();
		ibt3.root = ibt3.new Node(1);
		ibt3.root.left = ibt3.new Node(2);
		ibt3.root.right = ibt3.new Node(3);

		ibt3.root.left.right = ibt3.new Node(4);
		ibt3.root.left.right.right = ibt3.new Node(5);
		ibt3.root.left.right.right.right = ibt3.new Node(6);

		ibt3.printLeftView();

	}

	@Test
	@Ignore
	public void isBst() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();
		ibt.root = ibt.new Node(10);

		ibt.root.left = ibt.new Node(5);
		ibt.root.left.left = ibt.new Node(2);
		ibt.root.left.right = ibt.new Node(7);

		ibt.root.right = ibt.new Node(15);
		ibt.root.right.left = ibt.new Node(17);
		ibt.root.right.right = ibt.new Node(20);

		assertTrue(ibt.isBinaryTree());
	}

	@Test
	public void largestBst() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();
		ibt.root = ibt.new Node(60);

		ibt.root.left = ibt.new Node(65);
		ibt.root.right = ibt.new Node(70);

		ibt.root.left.left = ibt.new Node(50);
		assertTrue(2 == ibt.largestBst());

		IntBinaryTree ibt2 = new IntBinaryTree();
		ibt2.root = ibt2.new Node(50);

		ibt2.root.left = ibt2.new Node(30);

		ibt2.root.left.left = ibt2.new Node(5);
		ibt2.root.left.right = ibt2.new Node(20);

		ibt2.root.right = ibt2.new Node(60);

		ibt2.root.right.left = ibt2.new Node(45);
		ibt2.root.right.right = ibt2.new Node(70);

		ibt2.root.right.right.left = ibt2.new Node(65);
		ibt2.root.right.right.right = ibt2.new Node(80);
		ibt2.print(Option.Recursive, Traversal.InOrder);

		assertTrue(5 == ibt2.largestBst());
	}
}
