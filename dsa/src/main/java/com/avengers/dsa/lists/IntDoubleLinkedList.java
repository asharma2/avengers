package com.avengers.dsa.lists;

import java.util.Iterator;

public class IntDoubleLinkedList implements IntList {

	protected Node head, tail;

	/**
	 * @author atul_sharma
	 *
	 */
	class Node {
		int data;
		Node next;
		Node prev;

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
			return "Node [data=" + data + ", next=" + (next == null ? "-1" : next.data) + ", prev="
			        + (prev != null ? prev.data : "-1") + "]";
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
		return size(node.next) + 1;
	}

	@Override
	public boolean insert(Integer data) {
		Node x = new Node(data);
		if (isEmpty()) {
			head = tail = x;
		} else {
			tail.next = x;
			x.prev = tail;
			tail = tail.next;
		}
		return true;
	}

	@Override
	public boolean delete(Integer data) {
		if (!isEmpty()) {
			Node x = head;
			if (x.data == data) {
				head = head.next;
				return true;
			}
			Node p = null;
			while (x != null) {
				if (x.data == data) {
					Node f = x.next;
					p.next = f;
					f.prev = p;
					return true;
				}
				p = x;
				x = x.next;
			}
		}
		return false;
	}

	@Override
	public boolean exists(Integer data) {
		return search(head, data) != null;
	}

	private Node search(Node node, Integer data) {
		Node x = node;
		if (x == null)
			return null;
		if (x.data == data)
			return x;
		return search(x.next, data);
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
			if (idx++ == index)
				return x.data;
		}
		return null;
	}

	@Override
	public void reverse() {
		Node r = reverse(head);
		head = r;
	}

	private Node reverse(Node node) {
		Node x = node;
		if (x == null)
			return null;
		if (x.next == null)
			return x;
		Node n = x.next;
		System.out.println("n: " + n + ",x: " + x);
		Node r = reverse(n);
		System.out.println("n: " + n + ",x: " + x + ", r: " + r);
		x.next = n.next;
		n.next = x;
		n.prev = x.next;
		x.prev = r;
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
