package com.kedar;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Airport> {

	@Override
	public int compare(Airport o1, Airport o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getDistance(), o2.getDistance());
	}

}
