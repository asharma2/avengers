package com.avengers.dsa.sets;

import java.util.Iterator;

public class IntHashSet implements IntSet {

	protected Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	@Override
	public boolean add(Integer data) {
		Node x = new Node(data);
		if (isEmpty()) {
			head = x;
			return true;
		} else {
			Node s = head;
			while (s.next != null) {
				if (s.data == data)
					return false;
				s = s.next;
			}
			if (s.data == data)
				return false;
			s.next = x;
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
	public void delete(Integer data) {
		if (!isEmpty()) {
			if (head.data == data)
				head = head.next;
			else {
				Node x = head, p = null;
				while (x != null) {
					if (x.data == data) {
						p.next = x.next;
						return;
					}
					p = x;
					x = x.next;
				}
			}
		}
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
	public void print() {
		Iterator<Integer> iterator = iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
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

	@Override
	public boolean isEmpty() {
		return head == null;
	}

}
