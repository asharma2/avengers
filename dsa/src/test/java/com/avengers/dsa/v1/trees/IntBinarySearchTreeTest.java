package com.avengers.dsa.v1.trees;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.avengers.dsa.v1.trees.ITree.Order;

public class IntBinarySearchTreeTest {

	/**
	 * <code> 
	           15 
	         /     \ 
	       10      20 
	      / \     	/  \ 
	     8  12   16  25    
	 * </code>
	 */
	@Test
	@Ignore
	public void sumExists() throws Exception {
		IntBinarySearchTree intBst = new IntBinarySearchTree();
		intBst.insert(15);
		intBst.insert(10);
		intBst.insert(20);
		intBst.insert(8);
		intBst.insert(12);
		intBst.insert(17);
		intBst.insert(25);
		boolean bst = intBst.isSumExists(29);
		assertTrue(bst);
	}

	/**
	 * <code>
	*            50 
	*      	/    		 \ 
	*      30     		 70 
	*     /  \   		 /  \ 
	 *   20   40  60   80 
	 * </code>
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void delete() throws Exception {
		IntBinarySearchTree intBst = new IntBinarySearchTree();
		intBst.insert(50);
		intBst.insert(30);
		intBst.insert(20);
		intBst.insert(40);
		intBst.insert(70);
		intBst.insert(60);
		intBst.insert(80);
		Iterator<Integer> itr = intBst.inOrder(Order.Recursion);
		intBst.delete(20);
		itr = intBst.inOrder(Order.Recursion);
		intBst.delete(30);
		itr = intBst.inOrder(Order.Recursion);
		intBst.delete(50);
		itr = intBst.inOrder(Order.Recursion);
		List<Integer> list = ITree.convertIteratorToList(itr);
		assertTrue(list.size() == 4);
	}

	@Test
	public void bottomView() throws Exception {
		IntBinarySearchTree intBst = new IntBinarySearchTree();
		intBst.insert(50);
		intBst.insert(30);
		intBst.insert(20);
		intBst.insert(40);
		intBst.insert(70);
		intBst.insert(60);
		intBst.insert(80);
		List<Integer> list = ITree.convertIteratorToList(intBst.bottomView());
		assertTrue(4 == list.size());
	}

}
