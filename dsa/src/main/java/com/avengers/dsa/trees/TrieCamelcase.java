package com.avengers.dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class TrieCamelcase {

	TrieNode root;
	public static final int ALPHABET_SIZE = 26;

	class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isLeaf;
		List<String> word;

		public TrieNode() {
			isLeaf = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
			word = new ArrayList<String>();
		}
	}

	public void insert(String word) {
		if (root == null)
			root = new TrieNode();
		TrieNode pCrawl = root;
		for (int level = 0; level < word.length(); level++) {
			if (Character.isLowerCase(word.charAt(level)))
				continue;

			int index = word.charAt(level) - 'A';
			if (pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode();
			}
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isLeaf = true;
		(pCrawl.word).add(word);
	}

	public boolean search(String pattern) {
		TrieNode pCrawl = root;
		for (int level = 0; level < pattern.length(); level++) {
			int index = pattern.charAt(level) - 'A';
			if (pCrawl.children[index] == null)
				return false;
			pCrawl = pCrawl.children[index];
		}
		return pCrawl != null;
	}

}
