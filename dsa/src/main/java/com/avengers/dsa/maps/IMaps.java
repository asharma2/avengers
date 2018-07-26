package com.avengers.dsa.maps;

public interface IMaps<K, V> {

	V put(K key, V value);

	V get(K key);

	int size();

	void print();
}
