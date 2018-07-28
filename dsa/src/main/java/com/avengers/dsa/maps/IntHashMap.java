package com.avengers.dsa.maps;

import java.lang.reflect.Array;

public class IntHashMap implements IMaps<Integer, Integer> {

	@SuppressWarnings("unchecked")
	private Entry<Integer, Integer>[] entry = (Entry<Integer, Integer>[]) Array.newInstance(Entry.class, 16);

	@Override
	public Integer put(Integer key, Integer value) {
		int hashcode = key.hashCode();
		int size = entry.length;
		int idx = hashcode % size;
		Entry<Integer, Integer> lookup = entry[idx];
		if (lookup == null) {
			entry[idx] = new Entry<Integer, Integer>(key, value, hashcode);
		} else {
			while (lookup.next != null) {
				if (lookup.hashcode == hashcode) {
					if (value.equals(lookup.value)) {
						return value;
					}
					lookup = lookup.next;
				}
			}
			lookup.next = new Entry<Integer, Integer>(key, value, hashcode);
		}
		return value;
	}

	@Override
	public Integer get(Integer key) {
		int hashcode = key.hashCode();
		int size = entry.length;
		int idx = hashcode % size;
		Entry<Integer, Integer> lookup = entry[idx];
		return (lookup != null) ? lookup.value : null;
	}

	@Override
	public int size() {
		int size = 0;
		for (int i = 0; i < entry.length; i++) {
			Entry<Integer, Integer> node = entry[i];
			size += size(node);
		}
		return size;
	}

	private int size(Entry<Integer, Integer> node) {
		if (node == null)
			return 0;
		return size(node.next) + 1;
	}

	@Override
	public void print() {
		for (int i = 0; i < entry.length; i++) {
			Entry<Integer, Integer> node = entry[i];
			print(node);
		}
		System.out.println();
	}

	private void print(Entry<Integer, Integer> node) {
		if (node == null)
			return;
		System.out.print(node.value + " ");
		print(node.next);
	}

}
