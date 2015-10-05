package com.kedar;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CityTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewCity() {
		Airport city = new Airport("A");
		Assert.assertEquals("A",city.getName());
		Assert.assertEquals(0, city.getConnections().size());
		Assert.assertNull(city.getSourceAirport());
	}
	
	@Test
	public void testAddConnection() {
		Airport city = new Airport("B");
		Airport anotherCity = new Airport("C");
		
		Assert.assertEquals(0, city.getConnections().size());
		Connection conn = new Connection(anotherCity, 1);
		Assert.assertEquals(1, conn.getDistance());
		city.addConnection(conn);
		Assert.assertEquals(1, city.getConnections().size());
	}

}
