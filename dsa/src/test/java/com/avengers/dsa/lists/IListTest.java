package com.avengers.dsa.lists;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class IListTest {

	@Test
	@Ignore
	public void intSingleLinkedList() throws Exception {
		IntList intList = new IntSingleLinkedList();
		intList.insert(1);
		intList.insert(2);
		intList.insert(3);
		intList.insert(4);
		intList.insert(5);
		intList.delete(6);
		intList.print();
		assertEquals(5, intList.size());
		System.out.println(intList.size());
		intList.delete(3);
		assertEquals(4, intList.size());
		intList.print();
	}

	@Test
	@Ignore
	public void intDoubleLinkedList() throws Exception {
		IntList intList = new IntDoubleLinkedList();
		intList.insert(1);
		intList.insert(2);
		intList.insert(3);
		intList.insert(4);
		intList.insert(5);
		intList.insert(6);
		intList.print();
		assertEquals(6, intList.size());
		intList.delete(3);
		assertEquals(5, intList.size());
		intList.print();
	}

	@Test
	@Ignore
	public void intCircularLinkeList() throws Exception {
		IntList intList = new IntCircularLinkedList();
		intList.insert(1);
		intList.insert(2);
		intList.insert(3);
		intList.insert(4);
		intList.insert(5);
		intList.insert(6);
		intList.print();
		assertEquals(6, intList.size());
		intList.delete(3);
		assertEquals(5, intList.size());
		assertEquals(4, intList.get(3).intValue());
		intList.print();
	}

	@Test
	@Ignore
	public void intSortedLinkedList() throws Exception {
		IntList intList = new IntSortedLinkedList();
		intList.insert(10);
		intList.insert(2);
		intList.insert(12);
		intList.insert(4);
		intList.insert(1);
		assertEquals(5, intList.size());
		intList.delete(2);
		assertEquals(4, intList.size());
		assertEquals(10, intList.get(3).intValue());
	}

	@Test
	@Ignore
	public void intSortedCircularList() throws Exception {
		IntList intList = new IntSortedCircularList();
		intList.insert(10);
		intList.insert(2);
		intList.insert(12);
		intList.insert(4);
		intList.insert(1);
		assertEquals(5, intList.size());
		intList.delete(2);
		assertEquals(4, intList.size());
		assertEquals(12, intList.get(3).intValue());
	}

	@Test
	@Ignore
	public void intCircularDoubleLinkedList() throws Exception {
		IntList intList = new IntCircularDoubleLinkedList();
		intList.insert(10);
		intList.insert(2);
		intList.insert(12);
		System.out.println(intList.size());
		intList.delete(2);
		intList.print();
		intList.delete(12);
		System.out.println(intList.size());
		intList.print();
	}

	@Test
	public void intSortedDoubleLinkedList() throws Exception {
		IntList intList = new IntSortedDoubleLinkedList();
		intList.insert(10);
		intList.insert(2);
		intList.insert(12);
		intList.insert(1);
		intList.insert(5);
		intList.insert(3);
		System.out.println(intList.size());
		intList.print();
		System.out.println("Delete 2");
		intList.delete(2);
		intList.print();
		System.out.println("Delete 12");
		intList.delete(12);
		System.out.println(intList.size());
		intList.print();
	}

	@Test
	@Ignore
	public void intSortedCircularDoubleLinkedList() throws Exception {
		IntList intList = new IntSortedCircularDoubleLinkedList();
		intList.insert(10);
		intList.insert(2);
		intList.insert(12);
		intList.insert(1);
		intList.insert(5);
		intList.insert(3);
		System.out.println(intList.size());
		intList.print();
		System.out.println("Delete 2");
		intList.delete(2);
		intList.print();
		System.out.println("Delete 12");
		intList.delete(12);
		System.out.println(intList.size());
		intList.print();
	}

}
