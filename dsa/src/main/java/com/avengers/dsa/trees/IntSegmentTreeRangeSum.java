package com.avengers.dsa.trees;

public class IntSegmentTreeRangeSum {

	private int[] st;

	public IntSegmentTreeRangeSum(int[] arr, int n) {
		// height
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int size = (int) (2 * Math.pow(2, h) - 1);
		st = new int[size];
		buildSegment(arr, 0, n - 1, 0);
	}

	public void update(int arr[], int n, int i, int nVal) {
		if (i < 0 || i > n - 1)
			return;
		int diff = nVal - arr[i];
		update(0, n - 1, i, diff, 0);
	}

	private void update(int ss, int se, int i, int diff, int si) {
		if (i < ss || i > se)
			return;
		st[si] = st[si] + diff;
		if (se != ss) {
			int mid = (ss + se) / 2;
			update(ss, mid, i, diff, 2 * si + 1);
			update(mid + 1, se, i, diff, 2 * si + 2);
		}
	}

	public int getSum(int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1 || qs > qe)
			return -1;
		return getSum(0, n - 1, qs, qe, 0);
	}

	private int getSum(int ss, int se, int qs, int qe, int si) {
		if (qs <= ss && qe >= se)
			return st[si];
		if (se < qs || ss > qe)
			return 0;
		int mid = (ss + se) / 2;
		int lsum = getSum(ss, mid, qs, qe, 2 * si + 1);
		int rsum = getSum(mid + 1, se, qs, qe, 2 * si + 2);
		return lsum + rsum;
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
		st[si] = lseg + rseg;
		return st[si];
	}

}
