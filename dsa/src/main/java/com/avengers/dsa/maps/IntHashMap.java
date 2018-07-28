package com.avengers.dsa.maps;

import java.lang.reflect.Array;

public class IntHashMap<V> implements IMaps<Integer, V> {

	@SuppressWarnings("unchecked")
	private Entry<Integer, V>[] entry = (Entry<Integer, V>[]) Array.newInstance(Entry.class, 16);

	@Override
	public V put(Integer key, V value) {
		int hashcode = key.hashCode();
		int size = entry.length;
		int idx = hashcode % size;
		Entry<Integer, V> lookup = entry[idx];
		if (lookup == null) {
			entry[idx] = new Entry<Integer, V>(key, value, hashcode);
		} else {
			while (lookup.next != null) {
				if (lookup.hashcode == hashcode) {
					if (value.equals(lookup.value)) {
						return value;
					}
					lookup = lookup.next;
				}
			}
			lookup.next = new Entry<Integer, V>(key, value, hashcode);
		}
		return value;
	}

	@Override
	public V get(Integer key) {
		int hashcode = key.hashCode();
		int size = entry.length;
		int idx = hashcode % size;
		Entry<Integer, V> lookup = entry[idx];
		return (lookup != null) ? lookup.value : null;
	}

	@Override
	public int size() {
		int size = 0;
		for (int i = 0; i < entry.length; i++) {
			Entry<Integer, V> node = entry[i];
			size += size(node);
		}
		return size;
	}

	private int size(Entry<Integer, V> node) {
		if (node == null)
			return 0;
		return size(node.next) + 1;
	}

	@Override
	public void print() {
		for (int i = 0; i < entry.length; i++) {
			Entry<Integer, V> node = entry[i];
			print(node);
		}
		System.out.println();
	}

	private void print(Entry<Integer, V> node) {
		if (node == null)
			return;
		System.out.print(node.value + " ");
		print(node.next);
	}

}
