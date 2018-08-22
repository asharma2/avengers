package com.avengers.dsa.arrays;

import static com.avengers.dsa.arrays.ArrayProblems.canBePreOrder;
import static com.avengers.dsa.arrays.ArrayProblems.chocolateDistribution;
import static com.avengers.dsa.arrays.ArrayProblems.equilibriumPoint;
import static com.avengers.dsa.arrays.ArrayProblems.findMeanPoint;
import static com.avengers.dsa.arrays.ArrayProblems.findMedian;
import static com.avengers.dsa.arrays.ArrayProblems.findMissingNumber;
import static com.avengers.dsa.arrays.ArrayProblems.firstNonRepeatingCharacter;
import static com.avengers.dsa.arrays.ArrayProblems.generateLargestNumber;
import static com.avengers.dsa.arrays.ArrayProblems.isStringRotatedByN;
import static com.avengers.dsa.arrays.ArrayProblems.kadaneProblem;
import static com.avengers.dsa.arrays.ArrayProblems.largestSequenceOf0And1;
import static com.avengers.dsa.arrays.ArrayProblems.leaders;
import static com.avengers.dsa.arrays.ArrayProblems.maxInSlidingWindow;
import static com.avengers.dsa.arrays.ArrayProblems.maxOccuringCharacter;
import static com.avengers.dsa.arrays.ArrayProblems.maxProfitStock;
import static com.avengers.dsa.arrays.ArrayProblems.pythogorean;
import static com.avengers.dsa.arrays.ArrayProblems.removeAdjacents;
import static com.avengers.dsa.arrays.ArrayProblems.searchInSortedRotatedArray;
import static com.avengers.dsa.arrays.ArrayProblems.sort012;
import static com.avengers.dsa.arrays.ArrayProblems.sumLongestSubsequence;
import static com.avengers.dsa.arrays.ArrayProblems.swapInGroup;
import static com.avengers.dsa.arrays.ArrayProblems.tappingRainWater;
import static com.avengers.dsa.arrays.ArrayProblems.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

	@Test
	@Ignore
	public void _firstNonRepeatingCharacter() throws Exception {
		char c = firstNonRepeatingCharacter("geeksforgeeksandgeeksquizfor");
		assertTrue(c == 'a');
	}

	@Test
	@Ignore
	public void _searchInSortedRotatedArray() throws Exception {
		int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int x = 3;
		int idx = searchInSortedRotatedArray(arr, x);
		assertEquals(8, idx);
	}

	@Test
	@Ignore
	public void _findMedian() throws Exception {
		int arr1[] = { 1, 12, 15, 26, 38 };
		int arr2[] = { 2, 13, 17, 30, 45 };
		int idx = findMedian(arr1, arr2, 5);
		System.out.println(idx);

	}

	@Test
	@Ignore
	public void _maxOccuringWord() throws Exception {
		String arr[] = { "geeks", "for", "geeks", "a", "portal", "to", "learn", "can", "be", "computer", "science",
				"zoom", "yup", "fire", "in", "be", "data" };
		String maxOcc = maxOccuringWord(arr);
		assertEquals("geeks", maxOcc);
	}

	@Test
	@Ignore
	public void _findRepeatingAndMissing() throws Exception {
		int[] arr = { 4, 3, 5, 2, 1, 4 };
		int[] rm = findRepeatingAndMissing(arr);
		assertTrue(rm[0] == 4);
		assertTrue(rm[1] == 6);
	}

	@Test
	@Ignore
	public void _distinctNumbersInGroup() throws Exception {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;
		assertTrue(4 == distinctNumbersInGroup(arr, k).size());
	}

	@Test
	@Ignore
	public void palindrome() throws Exception {
		String str = "I am :IronnorI Ma, i";
		assertTrue(isPalindrome(str));
	}

	@Test
	@Ignore
	public void _minDiffTowerHeight() throws Exception {
		assertEquals(6, minDiffTowerHeight(new int[] { 2, 4, 6, 8, 10, 12 }, 6, 2));
	}

	@Test
	@Ignore
	public void _minimizeSumOfProduct() throws Exception {
		int a[] = { 3, 1, 1 }, b[] = { 6, 5, 4 };
		assertTrue(23 == minimizeSumOfProduct(a, b));
	}

	@Test
	@Ignore
	public void _findFirstAndLastOccurence() throws Exception {
		int[] a = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
		int res[] = findFirstAndLastOccurence(a, 5);
		assertTrue(2 == res[0]);
		assertTrue(5 == res[1]);
	}

	@Test
	@Ignore
	public void _knapsack() throws Exception {
		int vals[] = new int[] { 60, 100, 120 };
		int wght[] = new int[] { 10, 20, 30 };
		int w = 50;
		int wg = knapsack(w, wght, vals);
		assertTrue(220 == wg);
	}

	@Test
	@Ignore
	public void _coinChange() throws Exception {
		int arr[] = { 1, 2, 3 };
		int count = coinChange(arr, 4);
		assertTrue(4 == count);
	}

	@Test
	@Ignore
	public void _rearrangeOddAndEven() throws Exception {
		int[] arr = { 12, 34, 45, 9, 8, 90, 3 };
		rearrangeOddAndEven(arr);
		System.out.println(Arrays.toString(arr));
		assertTrue(arr[2] == 90);
	}

	@Test
	@Ignore
	public void _findLast2Digits() throws Exception {
		int n = 10;
		assertEquals(24, findLast2Digits((int) Math.pow(2, n)));
	}

	@Test
	public void _maxSum() throws Exception {
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		stack.push(9);
		queue.add(9);
		stack.push(10);
		queue.add(10);
		stack.push(0);
		queue.add(0);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		int sum = maxSum(stack, queue, 3);
		System.out.println(sum);
	}
}
