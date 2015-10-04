package com.kedar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DistanceComparatorTest {

	DistanceComparator comparator;
	@Before
	public void setUp() throws Exception {
		comparator = new DistanceComparator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		City cityA = new City("A");
		cityA.distance = 10;
		City cityB = new City("B");
		cityB.distance = 20;
		
		int result = comparator.compare(cityA, cityB);
		Assert.assertEquals(-1, result);
		result = comparator.compare(cityB, cityA);
		Assert.assertEquals(1, result);
		
	}

}
