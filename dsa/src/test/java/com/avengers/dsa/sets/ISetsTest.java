package com.avengers.dsa.sets;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ISetsTest {

	@Test
	public void intHashSet() throws Exception {
		IntHashSet set = new IntHashSet();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);
		set.add(4);
		assertEquals(4, set.size());
		set.delete(1);
		set.delete(4);
		set.print();
	}
}
