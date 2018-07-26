package com.avengers.dsa.lists;

public interface IList<T> {

	enum Traversal {
		Recursive, NonRecursive
	}

	boolean add(T item);

	void delete(T item);

	boolean search(T item);

	void reverse();

	int size();

	boolean isEmpty();

	void print();
}
