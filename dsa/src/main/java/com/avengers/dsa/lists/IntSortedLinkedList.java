package com.avengers.dsa.lists;

import java.util.Iterator;

public class IntSortedLinkedList implements IntList {

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

		@Override
		public String toString() {
			return data + " => " + (next != null ? next.data : "");
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
		return size(node.next) + 1;
	}

	@Override
	public boolean insert(Integer data) {
		Node x = new Node(data);
		if (isEmpty()) {
			head = tail = x;
		} else {
			if (head.data >= data) {
				x.next = head;
				head = x;
				return true;
			}

			if (tail.data <= data) {
				tail.next = x;
				tail = tail.next;
				return true;
			}

			Node s = head, f = head.next;
			while (f.data <= data) {
				s = f;
				f = f.next;
			}
			s.next = x;
			x.next = f;
		}
		return true;
	}

	@Override
	public boolean delete(Integer data) {
		if (!isEmpty()) {
			Node x = head;
			if (x.data == data) {
				x = x.next;
				return true;
			}

			Node n = head, p = null;
			while (n.data != data) {
				p = n;
				n = n.next;
			}

			if (n != null) {
				if (p != null) {
					p.next = n.next;
				} else {
					n = n.next;
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean exists(Integer data) {
		return search(head, data) != null;
	}

	private Node search(Node node, Integer data) {
		if (node == null)
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
		return get(head, 1, index);
	}

	private Integer get(Node node, int idx, int index) {
		if (node == null)
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
