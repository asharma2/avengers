package com.avengers.dsa.lists;

public class IntSortedCircularDoubleLinkedList extends AbstractDoubleLinkedList {

	@Override
	public int size() {
		return size(head);
	}

	@Override
	public boolean insert(Integer data) {
		return false;
	}

	@Override
	public boolean delete(Integer data) {
		return false;
	}

	@Override
	public boolean exists(Integer data) {
		return false;
	}

	@Override
	public Integer get(int index) {
		return getInternal2(index);
	}

	@Override
	public void reverse() {
		
	}

}
