package com.kedar;

/**
 * 
 * Represents connection (an edge in the graph) between 2 cities.
 *
 */
public class Connection {
	int distance;
	City city;
	
	public Connection(City city, int distance) {
		this.city = city;
		this.distance = distance;
	}
	
	public String toString() {
		return "[ " + city + " - " + distance + " ]";
	}

}
