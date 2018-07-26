package com.avengers.dsa.lists;

public class IntCircularLinkedList implements IList<Integer> {

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
			tail.next = head;
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
		return size(head.next, head) + 1;
	}

	private int size(Node node, Node head) {
		Node x = node;
		if (x != head) {
			return size(node.next, head) + 1;
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
		Node c = node;
		do {
			System.out.print(x.data + " ");
			x = x.next;
		} while (x != c);
		System.out.println();
	}

}
