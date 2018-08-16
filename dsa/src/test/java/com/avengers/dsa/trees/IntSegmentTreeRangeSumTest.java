package com.avengers.dsa.trees;

import org.junit.Test;

public class IntSegmentTreeRangeSumTest {

	@Test
	public void sumOfRange() throws Exception {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		IntSegmentTreeRangeSum segmentTree = new IntSegmentTreeRangeSum(arr, n);
		int rs = segmentTree.getSum(n, 1, 3);
		System.out.println(rs);
		segmentTree.update(arr, n, 1, 10);
		rs = segmentTree.getSum(n, 1, 3);
		System.out.println(rs);
	}
}
