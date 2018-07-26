package com.avengers.dsa.lists;

public class IntSingleLinkedList implements IList<Integer> {

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

	public boolean add(Integer item) {
		Node x = new Node(item);
		if (isEmpty()) {
			head = tail = x;
		} else {
			tail.next = x;
			tail = tail.next;
			tail.next = null;
		}
		return true;
	}

	public void delete(Integer item) {
		if (!isEmpty()) {
			Node x = head;
			Node f = head.next;
			while (f != null) {
				if (f.data == item) {
					Node r = f.next;
					x.next = r;
					f.next = null;
					return;
				}
				x = f;
				f = f.next;
			}
		}
	}

	public boolean search(Integer item) {
		return search(head, item) != null;
	}

	private Node search(Node node, Integer item) {
		Node x = node;
		if (x != null) {
			if (x.data == item)
				return x;
			return search(x.next, item);
		}
		return null;
	}

	public void reverse() {
		head = reverse(head);
	}

	private Node reverse(Node node) {
		Node x = node;
		if (x == null)
			return null;
		if (x.next == null)
			return x;

		Node f = x.next;
		x.next = null;
		Node r = reverse(f);
		f.next = x;
		return r;
	}

	public int size() {
		return size(head);
	}

	private int size(Node node) {
		Node x = node;
		if (x != null) {
			return size(node.next) + 1;
		}
		return 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void print() {
		print(head);
	}

	private void print(Node node) {
		Node x = node;
		while (x != null) {
			System.out.print(x.data + " ");
			x = x.next;
		}
		System.out.println();
	}

}
