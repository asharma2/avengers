package com.avengers.dsa.lists;

import java.util.Iterator;

public class IntSingleLinkedList implements IntList {

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
		Node x = node;
		if (x == null)
			return 0;
		return size(x.next) + 1;
	}

	@Override
	public boolean insert(Integer data) {
		if (isEmpty()) {
			head = tail = new Node(data);
		} else {
			tail.next = new Node(data);
			tail = tail.next;
		}
		return true;
	}

	@Override
	public boolean delete(Integer data) {
		Node x = head;
		if (!isEmpty()) {
			if (x.data == data) {
				x = x.next;
				head = x;
				return true;
			} else {
				Node p = x, n = x.next;
				while (n != null) {
					if (n.data == data) {
						p.next = n.next;
						return true;
					}
					p = n;
					n = n.next;
				}
			}
		}
		return false;
	}

	@Override
	public boolean exists(Integer data) {
		return exists(head, data) != null;
	}

	private Node exists(Node node, Integer data) {
		Node x = node;
		if (x.data == data) {
			return x;
		}
		return exists(x.next, data);
	}

	@Override
	public boolean clear() {
		head = tail = null;
		return true;
	}

	@Override
	public Integer get(int index) {
		Node x = head;
		int idx = 0;
		while (x != null) {
			if (idx++ == index) {
				return x.data;
			}
			x = x.next;
		}
		return null;
	}

	@Override
	public void reverse() {
		head = reverse(head);
	}

	private Node reverse(Node node) {
		Node x = node;
		if (x == null)
			return null;
		Node n = x.next;
		x.next = null;
		Node r = reverse(n);
		n.next = x;
		return r;
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
