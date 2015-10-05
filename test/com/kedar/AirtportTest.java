package com.kedar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirtportTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewAirport() {
		Airport airport = new Airport("A");
		Assert.assertEquals("A",airport.getName());
		Assert.assertEquals(0, airport.getConnections().size());
		Assert.assertNull(airport.getSourceAirport());
	}
	
	@Test
	public void testAddConnection() {
		Airport airport = new Airport("B");
		Airport neighbor = new Airport("C");
		
		Assert.assertEquals(0, airport.getConnections().size());
		Connection conn = new Connection(neighbor, 1);
		Assert.assertEquals(1, conn.getDistance());
		airport.addConnection(conn);
		Assert.assertEquals(1, airport.getConnections().size());
	}

}
