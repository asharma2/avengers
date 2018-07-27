package com.avengers.dsa.lists;

import java.util.Iterator;

public interface IList<T> {

	enum Traversal {
		Recursive, NonRecursive
	}

	boolean isEmpty();

	int size();

	boolean insert(T item);

	boolean delete(T item);

	boolean exists(T item);

	boolean clear();

	T get(int index);

	void reverse();

	Iterator<T> iterator();

	default void print() {
		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
	}
}
