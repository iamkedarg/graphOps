package com.kedar;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Class representing a 'City'
 *
 */
public class City {
	String name;
	List<Connection> connections;
	City sourceCity;
	Integer distance = Integer.MAX_VALUE;

	public City(String name) {
		this.name = name;
		this.connections = new ArrayList<>();
	}
	
	public void addConnection(Connection connection) {
		connections.add(connection);
	}
	
	public List<Connection> getConnections() {
		return connections;
	}
	
	public String toString() {
		return this.name;
	}
}
