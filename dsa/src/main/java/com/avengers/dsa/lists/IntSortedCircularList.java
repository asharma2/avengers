package com.avengers.dsa.lists;

import java.util.Iterator;

public class IntSortedCircularList implements IntList {

	protected Node head, tail;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this(data, null);
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int size() {
		return size(head);
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		if (node.next == head)
			return 1;
		return size(node.next) + 1;
	}

	@Override
	public boolean insert(Integer data) {
		Node x = new Node(data);
		if (isEmpty()) {
			head = tail = x;
			tail.next = head;
		} else {
			if (x.data < head.data) {
				x.next = head;
				head = x;
				tail.next = head;
				return true;
			}

			if (x.data > tail.data) {
				tail.next = x;
				x.next = head;
				tail = tail.next;
				return true;
			}

			Node p = null, c = head;
			do {
				if (x.data >= c.data) {
					p = c;
					c = c.next;
				}
				p.next = x;
				x.next = c;
				return true;
			} while (x != head);

		}
		return true;
	}

	@Override
	public boolean delete(Integer data) {
		if (!isEmpty()) {
			Node x = head;
			if (x.data == data) {
				x = x.next;
				head = x;
				tail.next = head;
				return true;
			}

			Node p = null;
			do {
				if (x.data == data) {
					p.next = x.next;
					return true;
				}
				p = x;
				x = x.next;
			} while (x != head);
		}
		return false;
	}

	@Override
	public boolean exists(Integer data) {
		if (!isEmpty()) {
			Node x = head;
			if (x.data == data)
				return true;
			return search(x.next, data) != null;
		}
		return false;
	}

	private Node search(Node node, Integer data) {
		if (node == head)
			return null;
		if (node.data == data)
			return node;
		return search(node.next, data);
	}

	@Override
	public boolean clear() {
		head = tail = null;
		return head == null;
	}

	@Override
	public Integer get(int index) {
		if (!isEmpty()) {
			Node x = head;
			if (index == 0)
				return x.data;
			return get(x.next, 1, index);
		}
		return null;
	}

	private Integer get(Node node, int idx, int index) {
		if (node == head)
			return null;
		if (idx == index)
			return node.data;
		return get(node.next, ++idx, index);
	}

	@Override
	public void reverse() {

	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			Node x = head;
			short count = 0;

			@Override
			public boolean hasNext() {
				return (count++ == 0) ? x != null : x != head;
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
