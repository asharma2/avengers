package com.avengers.dsa.sorts;

public interface IntSort extends Sort<Integer> {

	default void swap(Integer[] arr, int a, int b) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}

	default void display(Integer[] arr) {
		for (Integer a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
