package com.avengers.dsa.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayProblems {

	/**
	 * Given an array containing both negative and positive integers. Find the
	 * contiguous sub-array with maximum sum. <code>
	 *  [1,2,3] => 6
	 *  [-1,-2,-3,-4] => -1
	 * </code>
	 * 
	 * @param arr
	 */
	public static int kadaneProblem(int[] arr) {
		int maxSum = Integer.MIN_VALUE, sumBefore = 0;
		for (int i = 0; i < arr.length; i++) {
			sumBefore += arr[i];
			if (sumBefore > maxSum) {
				maxSum = sumBefore;
			}
			if (sumBefore < 0)
				sumBefore = 0;
		}
		return maxSum;
	}

	/**
	 * <code>
	 * 1 2 3 5 => 4
	 * </code>
	 * 
	 * @param arr
	 * @return
	 */
	public static int findMissingNumber(int[] arr) {
		int sum = (arr.length + 1) * (arr.length + 2) / 2;
		int sm = sum(arr);
		return sum - sm;
	}

	private static int sum(int[] arr) {
		int s = 0, e = arr.length - 1, sm = 0;
		while (s <= e) {
			if (s == e)
				sm += arr[s++];
			else
				sm += arr[s++] + arr[e--];
		}
		return sm;
	}

	/**
	 * Subarray with given sum
	 */
	public static int[] sumSubArray(int[] arr, int sum) {
		int currentSum = arr[0], start = 0;
		for (int i = 1; i <= arr.length; i++) {
			/**
			 * Remove start elements if currentSum is greater than sum
			 */
			while (currentSum > sum && start < i - 1) {
				currentSum = currentSum - arr[start];
				start++;
			}
			/**
			 * If current sum and sum are equal value found
			 */
			if (currentSum == sum) {
				return new int[] { start, i - 1 };
			}

			/**
			 * In case the currentSum != sum add the next element
			 */
			if (i < arr.length)
				currentSum += arr[i];
		}
		return null;
	}

	public static void sort012(int arr[]) {
		int s = 0, m = 0, e = arr.length - 1;
		while (m <= e) {
			if (arr[m] == 0) {
				swap(arr, s++, m++);
			} else if (arr[m] == 1) {
				m++;
			} else {
				swap(arr, m, e--);
			}
		}
	}

	public static int equilibriumPoint(int[] arr) {
		int sum = sum(arr), rem = 0;
		int s = 0;
		while (rem < sum) {
			rem += arr[s];
			if (sum == rem) {
				return s;
			}
			sum -= arr[s++];
		}
		return -1;
	}

	public static int sumLongestSubsequence(int[] arr) {
		int maxSum = Integer.MIN_VALUE, sumBefore = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] > 0) {
				sumBefore += arr[i];
			} else {
				if (maxSum < sumBefore) {
					maxSum = sumBefore;
				}
				sumBefore = sumBefore - arr[i - 1] + arr[i];
			}
		}
		return maxSum < sumBefore ? sumBefore : maxSum;
	}

	public static List<Integer> leaders(int[] arr) {
		List<Integer> leaders = new LinkedList<>();
		int e = arr.length - 1, max = arr[e];
		leaders.add(max);
		for (int i = e - 1; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				leaders.add(max);
			}
		}
		return leaders;
	}

	public static List<Integer> maxInSlidingWindow(int[] arr, int k) {
		List<Integer> maxs = new LinkedList<>();
		for (int i = 0; i < arr.length - k + 1; i++) {
			int sub[] = Arrays.copyOfRange(arr, i, i + k);
			int max = maxInArray(sub);
			maxs.add(max);
		}
		return maxs;
	}

	private static int maxInArray(int[] sub) {
		int s = 0, e = sub.length - 1;
		int max = sub[0];
		while (s <= e) {
			max = Math.max(max, Math.max(sub[s++], sub[e--]));
		}
		return max;
	}

	public static void swapInGroup(int[] arr, int k) {
		for (int i = 0; i < arr.length; i += k) {
			swapInGroup(arr, i, Math.min(i + k - 1, arr.length - 1));
		}
	}

	public static int tappingRainWater(int[] arr) {
		int left[] = new int[arr.length];
		left[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}
		int right[] = new int[arr.length];
		right[arr.length - 1] = arr[arr.length - 1];
		for (int j = arr.length - 2; j >= 0; j--) {
			right[j] = Math.max(right[j + 1], arr[j]);
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += Math.min(left[i], right[i]) - arr[i];
		}
		return sum;
	}

	public static int[] pythogorean(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] * arr[i];
		Arrays.sort(arr);
		for (int i = n - 1; i >= 2; i--) {
			int l = 0;
			int r = i - 1;
			while (l < r) {

				if (arr[l] + arr[r] == arr[i])
					return new int[] { (int) Math.sqrt(arr[l]), (int) Math.sqrt(arr[r]), (int) Math.sqrt(arr[i]) };

				if (arr[l] + arr[r] < arr[i])
					l++;
				else
					r--;
			}
		}
		return null;
	}

	public static int chocolateDistribution(int[] arr, int k) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - k; i++) {
			if (arr[i + k - 1] - arr[i] < min)
				min = arr[i + k - 1] - arr[i];
		}
		return min;
	}

	public static int maxProfitStock(int[] arr) {
		int n = arr.length, profit = 0, max = arr[n - 1];
		for (int j = n - 2; j >= 0; j--) {
			int p = max - arr[j];
			if (p > profit) {
				profit = p;
			}

			if (arr[j] > max)
				max = arr[j];
		}
		return profit;
	}

	private static void swapInGroup(int[] arr, int s, int e) {
		while (s < e) {
			swap(arr, s++, e--);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
