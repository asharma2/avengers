package com.avengers.dsa.maps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IMapsTest {

	@Test
	public void intHashMap() throws Exception {
		IntHashMap intMap = new IntHashMap();
		intMap.put(1, 11);
		intMap.put(2, 12);
		intMap.put(3, 13);
		intMap.put(4, 14);
		intMap.put(5, 15);
		intMap.put(6, 16);
		intMap.put(7, 17);
		assertEquals(15, intMap.get(5).intValue());
		assertEquals(7, intMap.size());
	}
}
