package com.avengers.dsa.lists;

import java.util.Iterator;

public class IntSortedDoubleLinkedList extends AbstractDoubleLinkedList {

	@Override
	public int size() {
		return size(head);
	}

	@Override
	public boolean insert(Integer data) {
		Node x = new Node(data);
		if (isEmpty()) {
			head = tail = x;
		} else {
			if (head.data >= data) {
				x.next = head;
				x.prev = null;
				head = x;
			} else if (tail.data <= data) {
				tail.next = x;
				x.prev = tail;
				tail = x;
			} else {
				Node s = head;
				do {
					if (s.data < x.data)
						s = s.next;
					Node f = s.next;
					s.next = x;
					x.prev = s;
					x.next = f;
					f.prev = x;
					return true;
				} while (s != head);
			}
		}
		return true;
	}

	@Override
	public boolean delete(Integer data) {
		if (!isEmpty()) {
			if (head.data == data) {
				head = head.next;
				head.prev = null;
				return true;
			} else if (tail.data == data) {
				tail = tail.prev;
				tail.next = null;
				return true;
			} else {
				Node s = head, f = head.next;
				while (f != null) {
					if (f.data < data) {
						s = f;
						f = f.next;
					}
					s.next = f.next;
					f.next.prev = s;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean exists(Integer data) {
		return searchInternal(data) != null;
	}

	@Override
	public Integer get(int index) {
		return getInternal(index);
	}

	@Override
	public void reverse() {

	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			Node x = head;

			@Override
			public boolean hasNext() {
				return x != null;
			}

			@Override
			public Integer next() {
				Integer data = x.data;
				x = x.next;
				return data;
			}
		};
	}
}
