package com.avengers.dsa.trees;

public class SegmentTreeMaxQuery {
	private int[] segment;

	public SegmentTreeMaxQuery(int[] arr) {
		int height = 2 * arr.length;
		segment = new int[height];
		constructSegmentTree(arr, segment, 0, arr.length - 1, 0);
	}

	private int constructSegmentTree(int[] arr, int[] segment, int ss, int se, int si) {
		if (ss == se) {
			segment[si] = arr[ss];
			return arr[ss];
		}
		int mid = (ss + se) / 2;
		int lseg = constructSegmentTree(arr, segment, ss, mid, 2 * si + 1);
		int rseg = constructSegmentTree(arr, segment, mid + 1, se, 2 * si + 2);
		segment[si] = Math.max(lseg, rseg);
		return segment[si];
	}

	public int rangeMaxQuery(int[] arr, int qs, int qe) {
		int n = arr.length;
		if (qs < 0 || qe > n - 1)
			return -1;
		return rangeMaxQuery(arr, 0, n - 1, qs, qe, 0);
	}

	private int rangeMaxQuery(int[] arr, int ss, int se, int qs, int qe, int qi) {
		if (qs <= ss && qe >= se)
			return segment[qs];
		if (se < qs || ss > qe)
			return Integer.MIN_VALUE;
		int mid = (ss + se) / 2;
		int lsum = rangeMaxQuery(arr, ss, mid, qs, qe, 2 * qi + 1);
		int rsum = rangeMaxQuery(arr, mid + 1, se, qs, qe, 2 * qi + 2);
		return Math.max(lsum, rsum);
	}

	public void updateMaxRange(int[] arr, int ui, int x) {
		int n = arr.length;
		ui = ui + n - 1;
		segment[ui] = x;
		while (ui > 1) {
			ui >>= 1;
			segment[ui] = Math.max(segment[2 * ui], segment[2 * ui + 1]);
		}
	}

}
