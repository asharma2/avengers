package com.avengers.dsa.trees;

public interface ITree<T> {

	enum Option {
		Recursive, NonRecursive
	}

	enum Traversal {
		PreOrder, PostOrder, InOrder, LevelOrder
	}

	int size();

	int size(int level);

	boolean isEmpty();

	T insert(T data) throws Exception;

	void delete(T data) throws Exception;

	boolean search(T data) throws Exception;

	void print(Option option, Traversal traversal);

	void printLeftView();

	int height();

	int countLeaf();

	int diameter();

	boolean isHeightBalanced();

	void mirror() throws Exception;

	int lowestCommonAncestor(int a, int b);

	int longestConsecutiveSequence();

	void printBottomView();
}
