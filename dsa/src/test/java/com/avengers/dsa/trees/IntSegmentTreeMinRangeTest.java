package com.avengers.dsa.trees;

import org.junit.Test;

public class IntSegmentTreeMinRangeTest {

	@Test
	public void sumOfRange() throws Exception {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		IntSegmentTreeMinRange st = new IntSegmentTreeMinRange(arr, n);
		int rs = st.rangeMinQuery(n, 1, 3);
		System.out.println(rs);
	}
}
