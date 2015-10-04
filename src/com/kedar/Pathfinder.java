package com.kedar;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Pathfinder {
	
	private Pathfinder() {
		
	}
	
	public final static String DESTINATION_CANT_REACHED = "Destination can't be reached.";

	public static String generateShortestPath(City startCity, City destinationCity) {
		
		if (startCity.connections.size() == 0) {
			return DESTINATION_CANT_REACHED;
		}
		PriorityQueue<City> queue = new PriorityQueue<>(10,
				new DistanceComparator());
		startCity.distance = 0;
		queue.add(startCity);

		boolean destinationReached = false;
		while (queue.size() > 0 && !destinationReached) {
			City city = queue.poll();

			if (city == destinationCity) {
				destinationReached = true;
			} else {
				processConnections(queue, city);
			}
		}
		
		if (destinationReached == false) {
			return DESTINATION_CANT_REACHED;
		}
		
		///build the path
		String s = buildPath(destinationCity);
		queue.clear();
		return s;
	}

	private static String buildPath(City destinationCity) {
		StringBuffer s = new StringBuffer();
		City city = destinationCity;
		while (city != null) {
			if (city.sourceCity != null)
				s.append(city.name + "-");
			else
				s.append(city.name);
			city = city.sourceCity;
		}
		return s.reverse().toString();
	}

	private static void processConnections(PriorityQueue<City> queue, City city) {
		List<Connection> connections = city.getConnections();
		for (Iterator<Connection> iterator = connections.iterator(); iterator
				.hasNext();) {
			Connection connection = iterator.next();
			City anotherCity = connection.city;
			
			if (anotherCity.distance > city.distance
					+ connection.distance) {
				anotherCity.distance = city.distance
						+ connection.distance;
				anotherCity.sourceCity = city;
				queue.remove(anotherCity);
				queue.add(anotherCity);
			}
		}
	}
}
