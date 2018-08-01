package com.avengers.dsa.sorts;

public class IntHeapSort implements IntSort {

	@Override
	public void sort(Integer[] arr) {
		heapSort(arr, 0, arr.length);
	}

	public Integer kthLargest(Integer[] arr, int k) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		for (int i = n - 1; i >= k; i--) {
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
		return arr[n - k];
	}

	private void heapSort(Integer[] arr, int s, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		for (int i = n - 1; i >= 0; i--) {
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
	}

	private void heapify(Integer[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, n, largest);
		}
	}

}
