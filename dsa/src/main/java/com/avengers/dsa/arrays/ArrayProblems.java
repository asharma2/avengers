
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
import java.util.TreeMap;

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
		Map<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int sum = 0; // Initialize sum of elements
		int max_len = 0; // Initialize result
		int ending_index = -1;
		int start_index = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == 0) ? -1 : 1;
		}

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0) {
				max_len = i + 1;
				ending_index = i;
			}

			if (hM.containsKey(sum)) {
				if (max_len < i - hM.get(sum + n)) {
					max_len = i - hM.get(sum + n);
					ending_index = i;
				}
			} else // Else put this sum in hash table
				hM.put(sum + n, i);
		}
		return max_len;
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

	public static void floodFill(int[][] screen, int M, int N, int x, int y, int newC) {
		int prevC = screen[x][y];
		floodFill(screen, M, N, x, y, prevC, newC);
	}

	private static void floodFill(int[][] screen, int M, int N, int x, int y, int prevC, int newC) {
		if (x < 0 || x >= M || y < 0 || y >= N)
			return;
		if (screen[x][y] != prevC)
			return;
		floodFill(screen, M, N, x + 1, y, prevC, newC);
		floodFill(screen, M, N, x - 1, y, prevC, newC);
		floodFill(screen, M, N, x, y + 1, prevC, newC);
		floodFill(screen, M, N, x, y - 1, prevC, newC);
	}

	public static int minDiffTowerHeight(int arr[], int n, int k) {
		Arrays.sort(arr);
		int ans = arr[n - 1] - arr[0];
		int small = arr[0] + k;
		int big = arr[n - 1] - k;
		if (small > big) {
			int tmp = small;
			small = big;
			big = tmp;
		} else {
			for (int i = 1; i < n; i++) {
				int subtract = arr[i] - k;
				int add = arr[i] + k;
				if (subtract >= small || add <= big)
					continue;
				if (big - subtract <= add - small)
					small = subtract;
				else
					big = add;
			}
		}
		return Math.min(ans, big - small);
	}

	public static int numberOfPaths(int m, int n) {
		int count[][] = new int[m][n];
		for (int i = 0; i < m; i++)
			count[i][0] = 1;

		for (int j = 0; j < n; j++)
			count[0][j] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++)
				count[i][j] = count[i - 1][j] + count[i][j - 1];
		}
		return count[m - 1][n - 1];
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

	public static int minimizeSumOfProduct(int[] a, int b[]) {
		if (a.length != b.length)
			return -1;
		Arrays.sort(a);
		Arrays.sort(b);
		int n = a.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += (a[i] * b[n - i - 1]);
		}
		return sum;
	}

	public static int[] findFirstAndLastOccurence(int arr[], int x) {
		int[] occ = { Integer.MAX_VALUE, Integer.MIN_VALUE };
		findFirstAndLastOccurence(arr, x, 0, arr.length - 1, occ);
		return occ;
	}

	private static void findFirstAndLastOccurence(int[] arr, int x, int s, int e, int[] occ) {
		if (s < e) {
			int m = (s + e) / 2;
			if (arr[m] == x) {
				if (occ[0] > m) {
					occ[0] = m;
					findFirstAndLastOccurence(arr, x, m - 2, m - 1, occ);
				}
				if (occ[1] < m) {
					occ[1] = m;
					findFirstAndLastOccurence(arr, x, m + 1, m + 2, occ);
				}
			}
			if (arr[m] > x) {
				findFirstAndLastOccurence(arr, x, 0, m - 1, occ);
			} else {
				findFirstAndLastOccurence(arr, x, m + 1, e, occ);
			}
		}
	}

	public static int knapsack(int w, int[] wgt, int[] vals) {
		return knapsack(w, wgt, vals, wgt.length);
	}

	private static int knapsack(int w, int[] wgt, int[] vals, int n) {
		if (n == 0 || w == 0)
			return 0;

		if (wgt[n - 1] > w)
			return knapsack(w, wgt, vals, n - 1);

		return Math.max(vals[n - 1] + knapsack(w - wgt[n - 1], wgt, vals, n - 1), knapsack(w, wgt, vals, n - 1));
	}

	public static int unboundedknapsack(int w, int[] val, int[] wght) {
		int n = val.length;
		int dp[] = new int[w + 1];
		for (int i = 0; i <= w; i++) {
			for (int j = 0; j < n; j++) {
				if (wght[j] <= i) {
					dp[i] = Math.max(dp[i], dp[i - wght[j]] + val[j]);
				}
			}
		}
		return dp[w];
	}

	public static int minCost(int[] cost) {
		int dp1 = 0, dp2 = 0;
		int n = cost.length;
		for (int i = 0; i < n; i++) {
			int dp0 = cost[i] + Math.min(dp1, dp2);
			dp2 = dp1;
			dp1 = dp0;
		}
		return Math.min(dp1, dp2);
	}

	public static int coinChange(int[] arr, int sum) {
		return coinChange(arr, sum, arr.length);
	}

	private static int coinChange(int[] arr, int sum, int n) {
		if (sum == 0)
			return 1;

		if (sum < 0)
			return 0;

		if (n <= 0 && sum >= 1)
			return 0;

		return coinChange(arr, sum, n - 1) + coinChange(arr, sum - arr[n - 1], n);
	}

	public static int numberOfWays(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return numberOfWays(n - 1) + numberOfWays(n - 2) + numberOfWays(n - 3);
	}

	public static int eggDrop(int n, int k) {
		if (k == 1 || k == 0)
			return k;
		if (n == 1)
			return k;
		int min = Integer.MAX_VALUE, x, res;

		for (x = 1; x <= k; x++) {
			res = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
			if (res < min)
				min = res;
		}

		return min + 1;
	}

	/**
	 * TODO
	 * 
	 * @param arr
	 * @return
	 */
	public static int longestSubString1GtThan0(int[] arr) {
		int maxlen = Integer.MIN_VALUE, sum = 0, n = arr.length;
		TreeMap<Integer, Integer> prevSum = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1)
				sum++;
			else
				sum--;
			if (sum > 0) {
				maxlen = i + 1;
			} else if (sum < 0) {
				if (prevSum.get(sum - 1) != prevSum.lastEntry().getValue()) {

				}
			}

		}
		return maxlen;
	}

	public static void rearrangeOddAndEven(int[] arr) {
		int n = arr.length;
		int left = 0, right = n - 1;
		while (left < right) {

			if (arr[left] % 2 == 0 && left < right) {
				left++;
				continue;
			}

			if (arr[right] % 2 == 1 && left < right) {
				right--;
				continue;
			}
			if (left < right)
				swap(arr, left++, right--);

		}
	}

	public static int shortestCommonSubsequence(String s1, String s2) {
		return shortestCommonSubsequence(s1, s2, s1.length(), s2.length());
	}

	private static int shortestCommonSubsequence(String s1, String s2, int m, int n) {
		if (m == 0)
			return 0;
		if (n == 0)
			return 0;
		if (s1.charAt(m - 1) == s2.charAt(n - 1))
			return 1 + shortestCommonSubsequence(s1, s2, m - 1, n - 1);
		return 1 + Math.min(shortestCommonSubsequence(s1, s2, m - 1, n), shortestCommonSubsequence(s1, s2, m, n - 1));
	}

	static class Sequence {
		int max;

		public Sequence setMax(int max) {
			this.max = max;
			return this;
		}
	}

	public static int longestIncreasingSubSequence(int[] arr) {
		Sequence seq = new Sequence().setMax(1);
		longestIncreasingSubSequence(arr, arr.length, seq);
		return seq.max;
	}

	private static int longestIncreasingSubSequence(int[] arr, int n, Sequence seq) {
		if (n == 1)
			return 1;
		int res, max_ending_here = 1;
		for (int i = 1; i < n; i++) {
			res = longestIncreasingSubSequence(arr, i, seq);
			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here) {
				max_ending_here = res + 1;
			}
		}
		if (seq.max < max_ending_here) {
			seq.max = max_ending_here;
		}
		return max_ending_here;
	}

	public static int printCountRec(int dist) {
		if (dist < 0)
			return 0;
		if (dist == 0)
			return 1;
		return printCountRec(dist - 1) + printCountRec(dist - 2) + printCountRec(dist - 3);
	}

	public static int findMinRecursion(int[] arr) {
		int sumTotal = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			sumTotal += arr[i];
		}
		return findMinRecursion(arr, n, 0, sumTotal);
	}

	private static int findMinRecursion(int[] arr, int i, int sumCal, int sumTotal) {
		if (i == 0)
			return Math.abs((sumTotal - sumCal) - sumCal);
		return Math.min(findMinRecursion(arr, i - 1, sumCal + arr[i - 1], sumTotal),
				findMinRecursion(arr, i - 1, sumCal, sumTotal));
	}

	/**
	 * <code>
	 * arr[] = {1, 5, 11, 5}
	 * Output: true 
	 * The array can be partitioned as {1, 5, 5} and {11}
	 * </code>
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean partition(int[] arr) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		if (sum % 2 != 0)
			return false;
		return partition(arr, n, sum / 2);
	}

	private static boolean partition(int[] arr, int n, int sum) {
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;
		if (arr[n - 1] > sum)
			return partition(arr, n - 1, sum);

		return partition(arr, n - 1, sum) || partition(arr, n, sum - arr[n - 1]);
	}

	public static int findLongestPath(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		int dp[][] = new int[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				dp[i][j] = -1;
		int result = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (dp[i][j] == -1)
					findLongestPath(arr, dp, 0, 0, row, col);

				// Update result if needed
				result = Math.max(result, dp[i][j]);
			}
		}
		return result;
	}

	private static int findLongestPath(int[][] mat, int dp[][], int i, int j, int row, int col) {
		if (i < 0 || i >= row || j < 0 || j >= col)
			return 0;
		if (dp[i][j] == -1)
			return dp[i][j];

		if (j < col - 1 && ((mat[i][j] + 1) == mat[i][j + 1]))
			return dp[i][j] = 1 + findLongestPath(mat, dp, i, j + 1, row, col);

		if (j > 0 && (mat[i][j] + 1 == mat[i][j - 1]))
			return dp[i][j] = 1 + findLongestPath(mat, dp, i, j - 1, row, col);

		if (i > 0 && (mat[i][j] + 1 == mat[i - 1][j]))
			return dp[i][j] = 1 + findLongestPath(mat, dp, i - 1, j + 1, row, col);

		if (i < row - 1 && (mat[i][j] + 1 == mat[i + 1][j]))
			return dp[i][j] = 1 + findLongestPath(mat, dp, i + 1, j + 1, row, col);

		return dp[i][j] = 1;
	}

	/**
	 * <code>
	 * Input : n = 28
	 * Output : 28
	 * 
	 * Input : n = 72
	 * Output : 96
	 * 2^72 = 4722366482869645213696
	 * </code>
	 * 
	 * @param n
	 * @return
	 */
	public static int findLast2Digits(int n) {
		int one = n % 10;
		n = n / 10;
		int tens = n % 10;
		tens = 10 * tens;
		n = tens + one;
		return n;
	}

	private boolean check(int i, int val) {
		if (i - val < 0)
			return false;
		return true;
	}

	public int minPrimes(int n) {
		int dp[] = new int[n + 1];
		for (int i = 1; i <= n; i++)
			dp[i] = Integer.MAX_VALUE;

		dp[0] = dp[2] = dp[3] = dp[5] = dp[7] = 1;
		for (int i = 1; i <= n; i++) {

			if (check(i, 2))
				dp[i] = Math.min(dp[i], 1 + dp[i - 2]);

			if (check(i, 3))
				dp[i] = Math.min(dp[i], 1 + dp[i - 3]);

			if (check(i, 5))
				dp[i] = Math.min(dp[i], 1 + dp[i - 5]);

			if (check(i, 7))
				dp[i] = Math.min(dp[i], 1 + dp[i - 7]);
		}

		if (dp[n] == Integer.MAX_VALUE)
			return -1;
		else
			return dp[n];
	}

}
