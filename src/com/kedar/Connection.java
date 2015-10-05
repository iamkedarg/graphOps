package com.kedar;

/**
 * 
 * Represents connection (an edge in the graph) between 2 cities.
 *
 */
public class Connection {
	private int distance;
	private Airport city;

	public Connection(Airport city, int distance) {
		this.city = city;
		this.distance = distance;
	}
	public int getDistance() {
		return distance;
	}

	public Airport getCity() {
		return city;
	}
	
	public String toString() {
		return "[ " + city + " - " + distance + " ]";
	}

}
