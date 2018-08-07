package com.avengers.dsa.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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

	public static int findMeanPoint(int[] arr) {
		int n = arr.length;
		int leftMax[] = new int[n];
		leftMax[0] = Integer.MIN_VALUE;

		// Fill leftMax[]1..n-1]
		for (int i = 1; i < n; i++)
			leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);

		// Initialize minimum from right
		int rightMin = Integer.MAX_VALUE;

		// Traverse array from right
		for (int i = n - 1; i >= 0; i--) {
			// Check if we found a required element
			if (leftMax[i] < arr[i] && rightMin > arr[i])
				return i;

			// Update right minimum
			rightMin = Math.min(rightMin, arr[i]);
		}

		// If there was no element matching criteria
		return -1;
	}

	public static void zigzag(int[] arr) {
		boolean flag = true;
		for (int i = 0; i < arr.length - 2; i++) {
			if (flag) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			} else {
				if (arr[i] < arr[i + 1])
					swap(arr, i, i + 1);
			}
			flag = !flag;
		}
	}

	public static int findUniqueNumberInSortedArray(int[] arr) {
		return searchSorted(arr, 0, arr.length - 1);
	}

	private static int searchSorted(int[] arr, int low, int high) {
		if (low > high)
			return -1;
		if (low == high)
			return arr[low];
		int mid = (low + high) / 2;
		if (mid % 2 == 0) {
			if (arr[mid] == arr[mid + 1]) {
				searchSorted(arr, mid + 2, high);
			} else {
				searchSorted(arr, low, mid - 1);
			}
		} else {
			if (arr[mid] == arr[mid - 1]) {
				searchSorted(arr, mid + 1, high);
			} else {
				searchSorted(arr, low, mid - 1);
			}
		}
		return -1;
	}

	public static boolean canBePreOrder(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int data = arr[i];
			if (data < root)
				return false;
			while (!stack.isEmpty() && stack.peek() < arr[i]) {
				root = stack.peek();
				stack.pop();
			}
			stack.push(arr[i]);
		}
		return true;
	}

	public static int largestSequenceOf0And1(int[] arr) {
		int totalOne = 0;
		int s = 0, e = arr.length - 1;
		while (s <= e) {
			if (s == e) {
				totalOne += arr[s++];
			} else {
				totalOne += arr[s++] + arr[e--];
			}
		}
		int totalZero = arr.length - totalOne;
		return (totalOne == arr.length || totalOne == 0) ? -1 : 2 * Math.min(totalOne, totalZero);
	}

	public static char maxOccuringCharacter(String str) {
		char[] ch = str.toCharArray();
		int[] occur = new int[256];
		int max = 0;
		char maxOccurChar = ' ';
		for (char c : ch) {
			int cnt = occur[c]++;
			if (cnt > max) {
				max = cnt;
				maxOccurChar = c;
			}
		}
		return maxOccurChar;
	}

	public static String removeAdjacents(String str) {
		char[] ch = str.toCharArray();
		int len = removeAdjacents(ch, 0, ch.length);
		return new String(ch, 0, len);
	}

	public static boolean isStringRotatedByN(String str, String str2, int n) {
		int len = str.length();
		if (str.length() < n)
			return false;
		String clockwise = str.substring(len - n) + str.substring(0, len - n);
		String anticlockwise = str.substring(n, len) + str.substring(0, n);
		return clockwise.equals(str2) || anticlockwise.equals(str2);
	}

	private static int removeAdjacents(char[] ch, int s, int e) {
		int k = 0, i = 1;
		for (i = 1; i < e; i++) {
			if (ch[i - 1] != ch[i]) {
				ch[k++] = ch[i - 1];
			} else {
				while (ch[i - 1] == ch[i])
					i++;
			}
		}
		ch[k++] = ch[i - 1];
		if (k == (e - s)) {
			return k;
		} else {
			return removeAdjacents(ch, s, k);
		}
	}

	public static String generateLargestNumber(Integer arr[]) {
		return generateLargestNumber(arr, 0, arr.length);
	}

	private static String generateLargestNumber(Integer[] arr, int s, int e) {
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String n1 = Integer.toString(o1) + Integer.toString(o2);
				String n2 = Integer.toString(o2) + Integer.toString(o1);
				return n2.compareTo(n1);
			}
		});
		final StringBuilder sb = new StringBuilder();
		for (Integer a : arr) {
			sb.append(a);
		}
		return sb.toString();
	}

	public static char firstNonRepeatingCharacter(String str) {
		List<Character> queue = new LinkedList<>();
		boolean[] repeat = new boolean[256];
		char[] ch = str.toCharArray();
		for (char c : ch) {
			if (!repeat[c]) {
				queue.add(c);
				repeat[c] = true;
			} else {
				queue.remove((Character) c);
			}
		}
		if (!queue.isEmpty()) {
			return queue.get(0);
		}
		return ' ';
	}

	public static int searchInSortedRotatedArray(int[] arr, int x) {
		return searchInSortedRotatedArray(arr, x, 0, arr.length - 1);
	}

	private static int searchInSortedRotatedArray(int[] arr, int x, int low, int high) {
		int pivot = findPivotOfSortedRotatedArray(arr, low, high);
		if (pivot == -1)
			return binarySearch(arr, x, low, high);
		if (arr[pivot] == x)
			return pivot;
		return (arr[0] <= x) ? binarySearch(arr, x, 0, pivot - 1) : binarySearch(arr, x, pivot + 1, high);
	}

	private static int binarySearch(int[] arr, int x, int low, int high) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (arr[mid] == x)
			return mid;
		return (arr[mid] <= x) ? binarySearch(arr, x, mid + 1, high) : binarySearch(arr, x, low, mid - 1);
	}

	public static int findMedian(int arr1[], int arr2[], int n) {
		int i = 0, j = 0;
		int m1 = -1, m2 = -1;
		int count;
		for (count = 0; count <= n; count++) {
			if (i == n) {
				m1 = m2;
				m2 = arr2[0];
			} else if (j == n) {
				m1 = m2;
				m2 = arr1[0];
			}

			if (arr1[i] < arr2[j]) {
				m1 = m2;
				m2 = arr1[i++];
			} else {
				m1 = m2;
				m2 = arr2[j++];
			}
		}
		return (m1 + m2) / 2;
	}

	private static int findPivotOfSortedRotatedArray(int[] arr, int low, int high) {
		if (low > high)
			return -1;
		if (low == high)
			return low;
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);

		return (arr[low] >= arr[mid]) ? findPivotOfSortedRotatedArray(arr, low, mid - 1)
		        : findPivotOfSortedRotatedArray(arr, mid + 1, high);
	}

	public static String maxOccuringWord(String[] strs) {
		Map<String, Integer> wCounts = new HashMap<>();
		int max = 0;
		String maxOccurence = "";
		for (String str : strs) {
			int count = 1;
			if (!wCounts.containsKey(str)) {
				wCounts.put(str, count);
			} else {
				count = wCounts.get(str) + 1;
				wCounts.put(str, count);
			}

			if (max < count) {
				max = count;
				maxOccurence = str;
			}
		}
		return maxOccurence;
	}

	public static int[] findRepeatingAndMissing(int[] arr) {
		int n = arr.length, sum = (n * (n + 1)) / 2, sm = 0;
		int[] rm = new int[2];
		int ca[] = new int[n];
		for (int i = 0; i < n; i++) {
			ca[arr[i] - 1]++;
			if (ca[arr[i] - 1] == 2)
				rm[0] = arr[i];
			sm += arr[i];
		}
		rm[1] = sum - sm + rm[0];
		return rm;
	}

	public static List<Integer> distinctNumbersInGroup(int[] arr, int k) {
		List<Integer> distincts = new LinkedList<>();
		int n = arr.length;
		for (int i = 0; i < n - k + 1; i++) {
			int distinct = distinct(arr, i, i + k);
			distincts.add(distinct);
		}
		return distincts;
	}

	private static int distinct(int[] arr, int s, int e) {
		int cnt = 0;
		Set<Integer> unq = new HashSet<>();
		while (s < e) {
			if (unq.add(arr[s++]))
				cnt++;
		}
		return cnt;
	}

	public static int minJumpsToReachEnd(int[] arr) {
		return minJumps(arr, arr.length);
	}

	private static int minJumps(int[] arr, int n) {
		int jumps[] = new int[n];
		if (arr[0] == 0)
			return Integer.MAX_VALUE;
		jumps[0] = 0;
		for (int i = 0; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {

			}
		}
		return jumps[0];
	}

	public static boolean isPalindrome(String str) {
		str = str.toLowerCase();
		int s = 0, e = str.length() - 1;
		while (s < e) {
			if (!(str.charAt(s) >= 65 && str.charAt(s) <= 91)) {
				s++;
				continue;
			}
			if (!(str.charAt(e) >= 65 && str.charAt(e) <= 91)) {
				e--;
				continue;
			}
			if (str.charAt(s++) != str.charAt(e--)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * TODO:
	 * 
	 * @param strs
	 * @param k
	 * @return
	 */
	public static String kthOccurence(String[] strs, int k) {
		Map<String, Integer> wCounts = new LinkedHashMap<>();
		for (String str : strs) {
			int count = 1;
			if (!wCounts.containsKey(str)) {
				wCounts.put(str, count);
			} else {
				count = wCounts.get(str) + 1;
				wCounts.put(str, count);
			}
		}
		return null;
	}

	public static int possibleString(int n, int r, int g, int b) {
		int fact[] = new int[n + 1];
		fact[0] = 1;
		for (int i = 1; i <= n; i++)
			fact[i] = fact[i - 1] * i;
		int left = n - (r + g + b);
		int sum = 0;
		for (int i = 0; i <= left; i++) {
			for (int j = 0; j <= left - i; j++) {
				int k = left - (i + j);
				sum = sum + fact[n] / (fact[i + r] * fact[j + b] * fact[k + g]);
			}
		}
		return sum;
	}

	public static void permute(String s) {
		permute(s, 0, s.length() - 1);
	}

	private static void permute(String str, int s, int e) {
		if (s == e)
			System.out.println(str);
		else {
			for (int i = s; i <= e; i++) {
				str = swap(str, s, i);
				permute(str, s + 1, e);
				str = swap(str, s, i);
			}
		}
	}

	private static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
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
