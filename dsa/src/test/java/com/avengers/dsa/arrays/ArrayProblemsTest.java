package com.avengers.dsa.arrays;

import static com.avengers.dsa.arrays.ArrayProblems.equilibriumPoint;
import static com.avengers.dsa.arrays.ArrayProblems.findMissingNumber;
import static com.avengers.dsa.arrays.ArrayProblems.kadaneProblem;
import static com.avengers.dsa.arrays.ArrayProblems.leaders;
import static com.avengers.dsa.arrays.ArrayProblems.maxInSlidingWindow;
import static com.avengers.dsa.arrays.ArrayProblems.sort012;
import static com.avengers.dsa.arrays.ArrayProblems.sumLongestSubsequence;
import static com.avengers.dsa.arrays.ArrayProblems.swapInGroup;
import static com.avengers.dsa.arrays.ArrayProblems.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class ArrayProblemsTest {

	@Test
	@Ignore
	public void _kadane() throws Exception {
		assertEquals(6, kadaneProblem(new int[] { 1, 2, 3 }));
		assertEquals(-1, kadaneProblem(new int[] { -1, -2, -3, -4 }));
	}

	@Test
	@Ignore
	public void _missing() throws Exception {
		assertEquals(4, findMissingNumber(new int[] { 1, 2, 3, 5 }));
	}

	@Test
	@Ignore
	public void _sort012() throws Exception {
		int arr[] = { 0, 2, 1, 2, 0 };
		sort012(arr);
		assertEquals(0, arr[0]);
		assertEquals(0, arr[1]);
		assertEquals(1, arr[2]);
		assertEquals(2, arr[3]);
		assertEquals(2, arr[4]);
	}

	@Test
	@Ignore
	public void _equilibriumpoint() throws Exception {
		int[] arr = new int[] { 1, 3, 5, 2, 2 };
		int eqp = equilibriumPoint(arr);
		assertEquals(5, arr[eqp]);
	}

	@Test
	@Ignore
	public void _sumLongestSubsequence() throws Exception {
		int[] arr = new int[] { 1, 101, 2, 3, 100, 4, 5 };
		int sum = sumLongestSubsequence(arr);
		System.out.println(sum);
	}

	@Test
	@Ignore
	public void _leaders() throws Exception {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		List<Integer> leaders = leaders(arr);
		assertTrue(leaders.size() == 3);
	}

	@Test
	@Ignore
	public void _maxInSlidingWindow() throws Exception {
		int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		List<Integer> maxs = maxInSlidingWindow(arr, 3);
		assertTrue(maxs.size() == 7);
	}

	@Test
	@Ignore
	public void _swapInGroup() throws Exception {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		swapInGroup(arr, 3);
		assertTrue(arr[4] == 4);
	}

	@Test
	@Ignore
	public void _tappingRainWater() throws Exception {
		int[] arr = new int[] { 3, 0, 0, 2, 0, 4 };
		int total = tappingRainWater(arr);
		assertTrue(total == 10);
	}

	@Test
	@Ignore
	public void _pythogorean() throws Exception {
		int[] arr = new int[] { 3, 2, 4, 6, 5 };
		int[] py = pythogorean(arr);
		System.out.println(Arrays.toString(py));
	}

	@Test
	@Ignore
	public void _chocolateDistribution() throws Exception {
		int[] arr = { 3, 4, 1, 9, 56, 7, 9, 12 };
		int min = chocolateDistribution(arr, 5);
		assertTrue(6 == min);
	}

	@Test
	@Ignore
	public void _maxProfitStock() throws Exception {
		int arr[] = { 7, 1, 5, 3, 6, 4 };
		int p = maxProfitStock(arr);
		assertTrue(p == 7);
	}

	@Test
	@Ignore
	public void _findMeanPoint() throws Exception {
		int arr[] = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };
		int mean = findMeanPoint(arr);
		System.out.println(mean);
	}

	@Test
	@Ignore
	public void _zigzag() throws Exception {
		int[] arr = { 4, 3, 7, 8, 6, 2, 1 };
		zigzag(arr);
		assertTrue(arr[0] == 3);
	}

	@Test
	@Ignore
	public void _canBePreOrder() throws Exception {
		int[] arr = { 40, 30, 35, 80, 100 };
		boolean preOrder = canBePreOrder(arr);
		assertTrue(preOrder);
	}

	@Test
	@Ignore
	public void _largestSequenceOf0And1() throws Exception {
		int[] arr = { 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0 };
		int max = largestSequenceOf0And1(arr);
		System.out.println(max);
	}

	@Test
	@Ignore
	public void _removeAdjacents() throws Exception {
		String str = "azxxzy";
		assertEquals("ay", removeAdjacents(str));
	}

	@Test
	@Ignore
	public void _isStringRotatedByN() throws Exception {
		assertTrue(isStringRotatedByN("amazon", "azonam", 2));
		assertTrue(isStringRotatedByN("amazon", "onamaz", 2));
	}

	@Test
	@Ignore
	public void _maxOccuringCharacter() throws Exception {
		char c = maxOccuringCharacter("amazonooo");
		assertTrue(c == 'o');
	}

	@Test
	@Ignore
	public void _generateLargestNumber() throws Exception {
		Integer arr[] = { 1, 34, 3, 98, 9, 76, 45, 4 };
		String number = generateLargestNumber(arr);
		assertEquals("998764543431", number);
	}

}
