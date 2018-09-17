package com.avengers.dsa.dynmc.prgmng;

import static com.avengers.dsa.dynmc.prgmng.DynamicProgramming.maxStolen;

import org.junit.Ignore;
import org.junit.Test;

public class DynamicProgrammingTest {

	@Test
	@Ignore
	public void _maxStolen() throws Exception {
		int[] arr = { 6, 7, 1, 3, 8, 2, 4 };
		int max = maxStolen(arr);
		System.out.println(max);
	}

	@Test
	public void _painters() throws Exception {
		int[] arr = { 10, 20, 30, 40 };
	}

}
