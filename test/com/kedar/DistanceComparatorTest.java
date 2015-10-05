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
		Airport cityA = new Airport("A");
		cityA.setDistance(10);
		Airport cityB = new Airport("B");
		cityB.setDistance(20);
		
		int result = comparator.compare(cityA, cityB);
		Assert.assertEquals(-1, result);
		result = comparator.compare(cityB, cityA);
		Assert.assertEquals(1, result);
		
	}

}
