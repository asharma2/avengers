package com.avengers.dsa.trees;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import com.avengers.dsa.trees.BinaryTree.Node;
import com.avengers.dsa.trees.ITree.Option;
import com.avengers.dsa.trees.ITree.Traversal;

public class IntBinaryTreeTest {

	@Test
	@Ignore
	public void leftView() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();
		ibt.root = new Node(12);
		ibt.root.left = new Node(10);
		ibt.root.right = new Node(30);
		ibt.root.right.left = new Node(25);
		ibt.root.right.right = new Node(40);

		ibt.printLeftView();

		IntBinaryTree ibt2 = new IntBinaryTree();
		ibt2.root = new Node(1);
		ibt2.root.left = new Node(2);
		ibt2.root.left.left = new Node(4);
		ibt2.root.left.right = new Node(5);
		ibt2.root.right = new Node(3);
		ibt2.root.right.right = new Node(6);

		ibt2.printLeftView();

		IntBinaryTree ibt3 = new IntBinaryTree();
		ibt3.root = new Node(1);
		ibt3.root.left = new Node(2);
		ibt3.root.right = new Node(3);

		ibt3.root.left.right = new Node(4);
		ibt3.root.left.right.right = new Node(5);
		ibt3.root.left.right.right.right = new Node(6);

		ibt3.printLeftView();

	}

	@Test
	@Ignore
	public void isBst() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();
		ibt.root = new Node(10);

		ibt.root.left = new Node(5);
		ibt.root.left.left = new Node(2);
		ibt.root.left.right = new Node(7);

		ibt.root.right = new Node(15);
		ibt.root.right.left = new Node(17);
		ibt.root.right.right = new Node(20);

		assertTrue(ibt.isBinaryTree());
	}

	@Test
	@Ignore
	public void largestBst() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();
		ibt.root = new Node(60);

		ibt.root.left = new Node(65);
		ibt.root.right = new Node(70);

		ibt.root.left.left = new Node(50);
		assertTrue(2 == ibt.largestBst());

		IntBinaryTree ibt2 = new IntBinaryTree();
		ibt2.root = new Node(50);

		ibt2.root.left = new Node(30);

		ibt2.root.left.left = new Node(5);
		ibt2.root.left.right = new Node(20);

		ibt2.root.right = new Node(60);

		ibt2.root.right.left = new Node(45);
		ibt2.root.right.right = new Node(70);

		ibt2.root.right.right.left = new Node(65);
		ibt2.root.right.right.right = new Node(80);
		ibt2.print(Option.Recursive, Traversal.InOrder);

		assertTrue(5 == ibt2.largestBst());
	}

	@Test
	@Ignore
	public void height() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();

		ibt.root = new Node(1);

		ibt.root.left = new Node(2);
		ibt.root.right = new Node(3);

		ibt.root.left.left = new Node(4);
		ibt.root.left.right = new Node(5);

		assertTrue(3 == ibt.height());
	}

	@Test
	@Ignore
	public void countLeaf() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();

		ibt.root = new Node(1);

		ibt.root.left = new Node(2);
		ibt.root.right = new Node(3);

		ibt.root.left.left = new Node(4);
		ibt.root.left.right = new Node(5);
		assertTrue(3 == ibt.countLeaf());

	}

	@Test
	@Ignore
	public void diameter() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();
		ibt.root = new Node(1);
		ibt.root.left = new Node(2);
		ibt.root.right = new Node(3);
		ibt.root.left.left = new Node(4);
		ibt.root.left.right = new Node(5);

		assertTrue(4 == ibt.diameter());
	}

	@Test
	@Ignore
	public void heightBalanced() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();
		ibt.root = new Node(1);
		ibt.root.left = new Node(2);
		ibt.root.right = new Node(3);
		ibt.root.left.left = new Node(4);
		ibt.root.left.right = new Node(5);
		ibt.root.left.left.left = new Node(8);
		System.out.println(ibt.isHeightBalanced());
	}

	@Test
	@Ignore
	public void mirror() throws Exception {
		IntBinaryTree ibt = new IntBinaryTree();
		ibt.root = new Node(1);
		ibt.root.left = new Node(3);
		ibt.root.right = new Node(2);
		ibt.root.right.left = new Node(5);
		ibt.root.right.right = new Node(4);
		ibt.print(Option.Recursive, Traversal.InOrder);
		ibt.mirror();
		ibt.print(Option.Recursive, Traversal.InOrder);
	}

	@Test
	public void _lowestCommonAnscestor() throws Exception {
		IntBinaryTree tree = new IntBinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int a = 10, b = 14;
		assertTrue(12 == tree.lowestCommonAncestor(a, b));
	}

}
