package com.avengers.dsa.lists;

public class IntCircularDoubleLinkedList extends AbstractDoubleLinkedList {

	@Override
	public int size() {
		return size(head);
	}

	@Override
	public boolean insert(Integer data) {
		Node x = new Node(data);
		if (isEmpty()) {
			head = tail = x;
			head.next = head;
			head.prev = tail;
		} else {
			x.next = head;
			x.prev = tail;
			tail.next = x;
			tail = tail.next;
			head.prev = tail;
		}
		return true;
	}

	@Override
	public boolean delete(Integer data) {
		if (!isEmpty()) {
			Node x = head;
			if (head.data == data) {
				head = head.next;
				head.prev = tail;
				tail.next = head;
				return true;
			}

			if (tail.data == data) {
				tail = tail.prev;
				tail.next = head;
				head.prev = tail;
				return true;
			}
			Node xx = null;
			do {
				if (x.data != data) {
					xx = x;
					x = x.next;
					continue;
				}
				break;
			} while (x != head);
			xx.next = x.next;
			x.next.prev = xx;
		}
		return false;
	}

	@Override
	public boolean exists(Integer data) {
		return search(head, data) != null;
	}

	@Override
	public Integer get(int index) {
		return get(head, 0, index);
	}

	@Override
	public void reverse() {

	}

}
