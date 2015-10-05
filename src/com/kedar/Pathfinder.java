package com.kedar;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Pathfinder {
	
	private Pathfinder() {
		
	}
	
	public final static String DESTINATION_CANT_REACHED = "Destination can't be reached.";

	public static String generateShortestPath(Airport startCity, Airport destinationCity) {
		
		if (startCity.getConnections().size() == 0) {
			return DESTINATION_CANT_REACHED;
		}
		PriorityQueue<Airport> airports = new PriorityQueue<>(10,
				new DistanceComparator());
		startCity.setDistance(0);
		airports.add(startCity);

		boolean destinationReached = false;
		while (airports.size() > 0 && !destinationReached) {
			Airport city = airports.poll();

			if (city == destinationCity) {
				destinationReached = true;
			} else {
				processConnections(airports, city);
			}
		}
		
		if (destinationReached == false) {
			return DESTINATION_CANT_REACHED;
		}
		
		///build the path
		String s = buildPath(destinationCity);
		airports.clear();
		return s;
	}

	private static String buildPath(Airport destinationCity) {
		StringBuffer s = new StringBuffer();
		Airport city = destinationCity;
		while (city != null) {
			if (city.getSourceAirport() != null)
				s.append(city.getName() + "-");
			else
				s.append(city.getName());
			city = city.getSourceAirport();
		}
		return s.reverse().toString();
	}

	private static void processConnections(PriorityQueue<Airport> airports, Airport city) {
		List<Connection> connections = city.getConnections();
		for (Iterator<Connection> iterator = connections.iterator(); iterator
				.hasNext();) {
			Connection connection = iterator.next();
			Airport neighbor = connection.getCity();
			
			if (neighbor.getDistance() > city.getDistance()
					+ connection.getDistance()) {
				neighbor.setDistance(city.getDistance()
						+ connection.getDistance());
				neighbor.setSourceAirport(city);
				airports.remove(neighbor);
				airports.add(neighbor);
			}
		}
	}
}
