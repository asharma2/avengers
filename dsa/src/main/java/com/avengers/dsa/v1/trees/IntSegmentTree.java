package com.avengers.dsa.v1.trees;

public class IntSegmentTree {

	private int[] segment;

	public IntSegmentTree(int[] arr) {
		int n = arr.length;
		int height = (int) Math.ceil(Math.log(n) / Math.log(2));
		int size = (int) (2 * Math.pow(2, height) - 1);
		segment = new int[size];
		constructSgmt(arr, 0, n - 1, 0);
	}

	private int constructSgmt(int[] arr, int ss, int se, int si) {
		if (ss == se) {
			segment[si] = arr[ss];
			return arr[ss];
		}
		int mid = (ss + se) / 2;
		segment[si] = constructSgmt(arr, ss, mid, 2 * si + 1) + constructSgmt(arr, mid + 1, se, 2 * si + 2);
		return segment[si];
	}

	public int getSum(int qs, int qe, int n) {
		if (qs < 0 || qe > n - 1 || qs > qe)
			return -1;
		return getSum(0, n - 1, qs, qe, 0);
	}

	private int getSum(int ss, int se, int qs, int qe, int qi) {
		if (qs <= ss && qe >= se)
			return segment[qi];
		if (se < qs || ss > qe)
			return 0;
		int mid = (ss + se) / 2;
		return getSum(ss, mid, qs, qe, 2 * qi + 1) + getSum(mid + 1, se, qs, qe, 2 * qi + 2);
	}

}
