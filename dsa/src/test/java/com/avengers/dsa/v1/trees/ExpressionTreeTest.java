package com.avengers.dsa.v1.trees;

import org.junit.Test;

public class ExpressionTreeTest {

	@Test
	public void runExpression() throws Exception {
		String postfix = "ab+ef*g*-";
		char[] ch = postfix.toCharArray();
		ExpressionTree et = new ExpressionTree();
		for (char c : ch)
			et.insert(c);
		et.inOrder();
	}
}
