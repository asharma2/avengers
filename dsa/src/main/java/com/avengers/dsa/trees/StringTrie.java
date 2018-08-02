package com.avengers.dsa.trees;

import java.util.LinkedList;
import java.util.List;

public class StringTrie {

	protected Node root;

	class Node {
		char data;
		int count;
		List<Node> nodes = new LinkedList<>();
		boolean end;
	}

}
