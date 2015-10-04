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
		City city = new City("A");
		Assert.assertEquals("A",city.name);
		Assert.assertEquals(0, city.connections.size());
		Assert.assertNull(city.sourceCity);
	}
	
	@Test
	public void testAddConnection() {
		City city = new City("B");
		City anotherCity = new City("C");
		
		Assert.assertEquals(0, city.connections.size());
		Connection conn = new Connection(anotherCity, 1);
		Assert.assertEquals(1, conn.distance);
		city.addConnection(conn);
		Assert.assertEquals(1, city.connections.size());
	}

}
