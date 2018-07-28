package com.avengers.dsa.lists;

public class IntSortedCircularDoubleLinkedList extends AbstractDoubleLinkedList {

	@Override
	public int size() {
		return size(head);
	}

	@Override
	public boolean insert(Integer data) {
		Node x = new Node(data);
		if (isEmpty()) {
			head = tail = x;
			head.prev = tail;
			tail.next = head;
		} else {
			if (head.data >= data) {
				x.next = head;
				x.prev = tail;
				head.prev = x;
				tail.next = x;
				head = x;
			} else if (tail.data <= data) {
				x.next = head;
				x.prev = tail;
				head.prev = x;
				tail.next = x;
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
				tail.next = head;
				head.prev = tail;
				return true;
			} else if (tail.data == data) {
				tail = tail.prev;
				tail.next = head;
				head.prev = tail;
				return true;
			} else {
				Node s = head, f = head.next;
				while (f != head) {
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
		return search(head, data) != null;
	}

	@Override
	public Integer get(int index) {
		return getInternal2(index);
	}

	@Override
	public void reverse() {

	}

}
