package com.kedar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PathFinderTest {
	Airport a,b,c,d,e,f,g,h;
	
	@Before
	public void setUp() throws Exception {
		
		a = new Airport("A");
		b = new Airport("B");
		c = new Airport("C");
		d = new Airport("D");
		e = new Airport("E");
		f = new Airport("F");
		g = new Airport("G");
		h = new Airport("H");

		final int DISTANCE = 1;

		Connection conn = new Connection(b, DISTANCE);
		h.addConnection(conn);

		conn = new Connection(a, DISTANCE);
		b.addConnection(conn);
		conn = new Connection(c, DISTANCE);
		b.addConnection(conn);

		conn = new Connection(f, DISTANCE);
		a.addConnection(conn);

		conn = new Connection(e, DISTANCE);
		c.addConnection(conn);
		conn = new Connection(d, DISTANCE);
		c.addConnection(conn);

		conn = new Connection(e, DISTANCE);
		d.addConnection(conn);

		conn = new Connection(b, DISTANCE);
		e.addConnection(conn);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIfStartCityDoesntHaveConnections() {
		String path = Pathfinder.generateShortestPath(g, h);
		Assert.assertEquals("Test case testing if source city doesn't have connection failed", Pathfinder.DESTINATION_CANT_REACHED , path);
	}
	
	@Test
	public void testIfDestinationCantBeReached() {
		String path = Pathfinder.generateShortestPath(c,h);
		Assert.assertEquals("Test case testing if destination city can't be reached failed", Pathfinder.DESTINATION_CANT_REACHED , path);
	}
	
	@Test
	public void testForShotestPath() {
		String path = Pathfinder.generateShortestPath(c, f);
		Assert.assertEquals("Test case testing shortest path failed", "C-E-B-A-F" , path);
		Assert.assertEquals(4, f.getDistance().intValue());
	}
}
