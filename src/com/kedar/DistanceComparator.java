package com.kedar;

import java.util.Comparator;

public class DistanceComparator implements Comparator<City> {

	@Override
	public int compare(City o1, City o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.distance, o2.distance);
	}

}
