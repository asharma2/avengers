package com.avengers.dsa.trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SegmentTreeMaxQueryTest {

	@Test
	public void rangeQueries() throws Exception {
		int arr[] = { 2, 6, 7, 5, 18, 86, 54, 2 };
		SegmentTreeMaxQuery stmq = new SegmentTreeMaxQuery(arr);
		int maxVal = stmq.rangeMaxQuery(arr, 2, 7);
		assertEquals(86, maxVal);
		stmq.updateMaxRange(arr, 3, 90);
		maxVal = stmq.rangeMaxQuery(arr, 2, 6);
		assertEquals(90, maxVal);

	}
}
