package com.avengers.dsa.sorts;

public interface Sort<T extends Comparable<T>> {

	void sort(T[] items);
}
