package com.kedar;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Class representing a 'City'
 *
 */
public class Airport {
	private String name;
	private List<Connection> connections;
	private Airport sourceAirport;
	private Integer distance = Integer.MAX_VALUE;

	public Airport(String name) {
		this.name = name;
		this.connections = new ArrayList<>();
	}
	
	public void addConnection(Connection connection) {
		connections.add(connection);
	}
	
	public List<Connection> getConnections() {
		return connections;
	}
	
	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceCity) {
		this.sourceAirport = sourceCity;
	}

	public String getName() {
		return name;
	}

	public Integer getDistance() {
		return distance;
	}
	
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	public String toString() {
		return this.name;
	}
}
