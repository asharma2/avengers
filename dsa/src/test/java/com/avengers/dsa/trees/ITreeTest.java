package com.avengers.dsa.trees;

import org.junit.Test;

import com.avengers.dsa.trees.ITree.Option;
import com.avengers.dsa.trees.ITree.Traversal;

public class ITreeTest {

	@Test
	public void bst() throws Exception {
		ITree<Integer> intBst = new IntBinarySearchTree();
		intBst.insert(100);
		intBst.insert(50);
		intBst.insert(200);
		intBst.insert(75);
		intBst.insert(25);
		intBst.insert(35);
		intBst.insert(40);
		intBst.insert(30);
		intBst.insert(250);
		intBst.insert(150);
		intBst.insert(12);
		intBst.insert(6);
		intBst.insert(15); 
		intBst.insert(32);
		intBst.insert(27);
		intBst.insert(29);
		intBst.print(Option.Recursive, Traversal.InOrder);
		intBst.print(Option.Recursive, Traversal.PreOrder);
		intBst.print(Option.Recursive, Traversal.PostOrder);
		intBst.delete(25);
		intBst.print(Option.Recursive, Traversal.InOrder);
		intBst.print(Option.Recursive, Traversal.PreOrder);
		intBst.print(Option.Recursive, Traversal.PostOrder);
	}
}
