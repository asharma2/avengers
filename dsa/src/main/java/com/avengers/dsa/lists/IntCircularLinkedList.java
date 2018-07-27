package com.avengers.dsa.lists;

import java.util.Iterator;

public class IntCircularLinkedList implements IntList {

	protected Node head, tail;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data + "->" + (next != null ? next.data : "");
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
			x.next = head;
			tail.next = x;
			tail = tail.next;
		}
		return false;
	}

	@Override
	public boolean delete(Integer data) {
		if (!isEmpty()) {
			Node x = head;
			if (x.data == data) {
				x = x.next;
				tail.next = x;
				return true;
			} else {
				Node p = null, n = x.next;
				while (n != head) {
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
		return search(head, data) != null;
	}

	private Node search(Node node, Integer data) {
		if (node.next == head)
			return null;
		if (node.data == data)
			return node;
		return search(node.next, data);
	}

	@Override
	public boolean clear() {
		head = tail = null;
		return true;
	}

	@Override
	public Integer get(int index) {
		return get(head, 1, index);
	}

	private Integer get(Node node, int idx, int index) {
		if (node == null)
			return null;
		if (idx == index) {
			return node.data;
		}
		return get(node.next, ++idx, index);
	}

	@Override
	public void reverse() {

	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			Node x = head;
			int count = 0;

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
