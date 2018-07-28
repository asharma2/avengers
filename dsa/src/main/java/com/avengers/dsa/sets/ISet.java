package com.avengers.dsa.sets;

public interface ISet<T extends Comparable<T>> extends Iterable<T> {

	boolean isEmpty();
	
	boolean add(T item);

	boolean exists(T item);

	void delete(T item);

	int size();

	void print();

}
