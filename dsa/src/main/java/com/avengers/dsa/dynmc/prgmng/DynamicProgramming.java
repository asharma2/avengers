package com.avengers.dsa.dynmc.prgmng;

public class DynamicProgramming {

	public static int nthUglyNumber(int n) {
		int ugly[] = new int[n + 1];
		int i2 = 0, i3 = 0, i5 = 0;
		int mul2 = 2, mul3 = 3, mul5 = 5;
		int nextUglyNo = 1;
		for (int i = 0; i < n; i++) {
			nextUglyNo = Math.min(mul2, Math.min(mul3, mul5));
			ugly[i] = nextUglyNo;
			if (nextUglyNo == mul2) {
				i2 = i2 + 1;
				mul2 = ugly[i2] * 2;
			} else if (nextUglyNo == mul3) {
				i3 = i3 + 1;
				mul3 = ugly[i3] * 2;
			} else if (nextUglyNo == mul5) {
				i5 = i5 + 1;
				mul5 = ugly[i5] * 5;
			}
		}
		return nextUglyNo;
	}

	public static int maxStolen(int[] arr) {
		return maxStolen(arr, 0, arr.length);
	}

	private static int maxStolen(int[] arr, int i, int n) {
		if (i >= n)
			return 0;
		return Math.max(arr[i] + maxStolen(arr, i + 2, n), maxStolen(arr, i + 1, n));
	}

	public static int keyCount(int[][] keypad) {
		return keyCount(keypad, keypad.length, keypad[0].length, 0, 0);
	}

	private static int keyCount(int[][] keypad, int r, int c, int ri, int ci) {
		if (ri < 0 || ci < 0)
			return 0;
		if (ri >= r)
			return 0;
		if (ci >= c)
			return 0;

		return 1 + keyCount(keypad, r, c, ri + 1, ci) + keyCount(keypad, r, c, ri - 1, ci) + keyCount(keypad, r, c, ri, ci + 1)
		        + keyCount(keypad, r, c, ri, ci - 1);
	}

	public static String shortedPossibleCombination(String s1, String s2) {
		return shortedPossibleCombination(s1, 0, s1.length(), s2, 0, s2.length());
	}

	private static String shortedPossibleCombination(String s1, int i, int n, String s2, int j, int m) {
		if (n == 0)
			return s2;
		if (m == 0)
			return s1;
		if (i == n)
			return s2.substring(m - 1);
		if (j == m)
			return s1.substring(n - 1);

		if (s1.charAt(i) == s2.charAt(j)) {
			String result = s1.charAt(i) + shortedPossibleCombination(s1, ++i, n, s2, ++j, m);
			return result;
		} else {
			String x = "" + s1.charAt(i) + s2.charAt(j);
			String a = shortedPossibleCombination(s1, i + 1, n, s2, j, m);
			String b = shortedPossibleCombination(s2, i, n, s2, j + 1, m);
			return x + (a.length() < b.length() ? a : b);
		}
	}

}
