package com.avengers.dsa.lists;

import java.util.Iterator;

public abstract class AbstractDoubleLinkedList implements IntList {

	protected Node head, tail;

	protected class Node {
		int data;
		Node next, prev;

		public Node(int data) {
			this(data, null, null);
		}

		public Node(int data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		@Override
		public String toString() {
			return (prev != null ? prev.data : "x") + " <= " + data + " => " + (next != null ? next.data : "x");
		}
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean clear() {
		head = tail = null;
		return head == null;
	}

	protected int size(Node node) {
		if (node == tail)
			return 1;
		return size(node.next) + 1;
	}

	protected Node search(Node node, Integer data) {
		if (node == null)
			return null;
		if (node.data == data)
			return node;
		if (node == tail)
			return null;
		return search(node.next, data);
	}

	protected Integer get(Node node, int idx, int index) {
		if (node == null)
			return null;
		if (idx++ == index)
			return node.data;
		if (node == tail)
			return null;
		return get(node.next, idx, index);
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

	protected Node searchInternal(Integer data) {
		if (!isEmpty()) {
			if (head.data == data)
				return head;
			if (tail.data == data)
				return tail;

			Node x = head;
			while (x != null) {
				if (x.data == data)
					return x;
				x = x.next;
			}
		}
		return null;
	}

	protected Integer getInternal(int index) {
		Node x = head;
		int idx = 0;
		while (x != null) {
			if (idx++ == index)
				return x.data;
			x = x.next;
		}
		return null;
	}
}
