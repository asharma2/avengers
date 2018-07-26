package com.avengers.dsa.sets;

public interface ISet<T extends Comparable<T>> extends Iterable<T> {

	boolean add(T item);

	boolean search(T item);

	void delete(T item);

	int size();

	void print();

}
