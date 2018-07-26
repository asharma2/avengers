package com.avengers.dsa.lists;

public class IntSortedLinkedList implements IList<Integer> {

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
	public boolean add(Integer data) {
		if (isEmpty()) {
			head = tail = new Node(data);
		} else {
			head = insert(head, data);
		}
		return false;
	}

	private Node insert(Node node, Integer data) {
		Node x = node;
		Node n = new Node(data);

		if (data <= x.data) {
			n.next = x;
			return n;
		}

		if (data >= tail.data) {
			tail.next = n;
			tail = tail.next;
			return x;
		}

		Node c = x, p = null;
		while (c != null) {
			if (data > c.data) {
				p = c;
				c = c.next;
				continue;
			}
			break;
		}
		p.next = n;
		n.next = c;
		return node;
	}

	@Override
	public void delete(Integer item) {
		delete(head, item);
	}

	private boolean delete(Node node, Integer data) {
		Node x = node, p = null;
		while (x != null) {
			if (x.data == data) {
				Node n = x.next;
				p.next = n;
				return true;
			}
			p = x;
			x = x.next;
		}
		return false;
	}

	@Override
	public boolean search(Integer item) {
		return search(head, item);
	}

	private boolean search(Node node, Integer data) {
		Node x = node;
		if (x == null)
			return false;
		if (x.data == data)
			return true;
		return search(x.next, data);
	}

	@Override
	public void reverse() {
		head = revese(head);
	}

	private Node revese(Node node) {
		Node x = node;
		if (x == null)
			return null;
		if (x.next == null)
			return x;
		Node f = x.next;
		x.next = null;
		Node r = revese(f);
		f.next = x;
		return r;
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
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void print() {
		Node x = head;
		while (x != null) {
			System.out.print(x.data + (x.next != null ? "," : ""));
			x = x.next;
		}
	}

}
