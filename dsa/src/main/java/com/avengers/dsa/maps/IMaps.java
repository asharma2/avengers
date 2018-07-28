package com.avengers.dsa.maps;

public interface IMaps<K, V> {

	class Entry<K, V> {
		public K key;
		public V value;
		protected int hashcode;
		Entry<K, V> next;

		public Entry(K key, V value, int hashcode) {
			this.key = key;
			this.value = value;
			this.hashcode = hashcode;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public int getHashcode() {
			return hashcode;
		}

	}

	V put(K key, V value);

	V get(K key);

	int size();

	void print();
}
