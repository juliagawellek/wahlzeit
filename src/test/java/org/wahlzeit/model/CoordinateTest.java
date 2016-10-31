package org.wahlzeit.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;



public class CoordinateTest {
	
	
	private Coordinate Vancouver  = new Coordinate(49.11, -123.11);
	private Coordinate Nuremberg = new Coordinate(49.29,11.04);

	
	//testing if Vancouver is not null
	@Test()
	public void test(){
	assertNotNull(Vancouver);
	}
	
	//testing if distance is calculuted properly
	@Test()
	public void testGetDistance(){
		double distance_hard = 8228;
		
		double distance_methode = Vancouver.getDistance(Nuremberg);
		System.out.println(distance_methode);
		
		assertEquals(distance_hard, distance_methode,0.5);
		
	}
	
	//testing if distance calculation is independet of order
	@Test()
	public void testOrder(){
		double distance1 = Vancouver.getDistance(Nuremberg);
		double distance2 = Nuremberg.getDistance(Vancouver);
		assertEquals(distance1, distance2, 0.1);
	}
	
	//testing if distance between same points is 0
	@Test()
	public void testEquals(){
		double distance1 = Vancouver.getDistance(Vancouver);
		assertEquals(distance1,0,0.0);
		
	}
	
	@Test()
	public void testGetLatitude(){
		double latitude_methode = Vancouver.getLatitude();
		double latitude_hard = 49.11;
		assertEquals(latitude_methode, latitude_hard, 0.1);
	}
	
	public void testGetLondigute(){
		double longitude_method = Vancouver.getLongitude();
		double longitude_hard = 123.11;
		assertEquals(longitude_method, longitude_hard, 0.1);
	}
}
