package com.avengers.dsa.lists;

import org.junit.Ignore;
import org.junit.Test;

public class IListTest {

	@Test
	@Ignore
	public void print() throws Exception {
		IList<Integer> intList = new IntCircularLinkedList();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		intList.add(6);
		System.out.println(intList.size());
		intList.delete(4);
		System.out.println(intList.size());
		intList.print();
	}

	@Test
	public void intSorted() throws Exception {
		IList<Integer> intList = new IntSortedLinkedList();
		intList.add(10);
		intList.add(20);
		intList.add(1);
		intList.add(5);
		intList.add(9);
		intList.delete(10);
		intList.reverse();
		intList.print();
	}
}
