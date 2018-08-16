package com.avengers.dsa.trees;

public class IntSegmentTreeMinRange {

	private int[] st;

	public IntSegmentTreeMinRange(int[] arr, int n) {
		// height
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int size = (int) (2 * Math.pow(2, h) - 1);
		st = new int[size];
		buildSegment(arr, 0, n - 1, 0);
	}

	public int rangeMinQuery(int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1 || qs > qe)
			return -1;
		return rangeMinQuery(0, n - 1, qs, qe, 0);
	}

	private int rangeMinQuery(int ss, int se, int qs, int qe, int si) {
		if (qs <= ss && qe >= se)
			return st[si];
		if (se < qs || ss > qe)
			return Integer.MAX_VALUE;
		int mid = (ss + se) / 2;
		int lsum = rangeMinQuery(ss, mid, qs, qe, 2 * si + 1);
		int rsum = rangeMinQuery(mid + 1, se, qs, qe, 2 * si + 2);
		return Math.min(lsum, rsum);
	}

	private int buildSegment(int[] arr, int ss, int se, int si) {
		System.out.println("ss: " + ss + ",se: " + se + ",si: " + si);
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}
		int mid = (ss + se) / 2;
		int lseg = buildSegment(arr, ss, mid, 2 * si + 1);
		int rseg = buildSegment(arr, mid + 1, se, 2 * si + 2);
		st[si] = Math.min(lseg, rseg);
		return st[si];
	}

}
