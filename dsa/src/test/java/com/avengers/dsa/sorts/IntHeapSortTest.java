package com.avengers.dsa.sorts;

import org.junit.Ignore;
import org.junit.Test;

public class IntHeapSortTest {

	@Test
	@Ignore
	public void sort() throws Exception {
		Integer arr[] = { 12, 11, 13, 5, 6, 7 };
		IntHeapSort ihs = new IntHeapSort();
		ihs.sort(arr);
		ihs.display(arr);
	}

	@Test
	public void kthLargest() throws Exception {
		Integer arr[] = { 12, 11, 13, 5, 6, 7 };
		IntHeapSort ihs = new IntHeapSort();
		System.out.println(ihs.kthLargest(arr, 3));
	}
}
