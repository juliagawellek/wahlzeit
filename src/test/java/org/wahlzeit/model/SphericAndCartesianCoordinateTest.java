package org.wahlzeit.model;
import org.wahlzeit.model.CoordinateException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Before;
import org.junit.Test;

public class SphericAndCartesianCoordinateTest {
	
	private double radius = 6371.0; //kilometers 
	private SphericCoordinate vancouver;
	private SphericCoordinate nuremberg;
	private CartesianCoordinate p1;
	private CartesianCoordinate p2;
	private CartesianCoordinate test;
	
@Before
	public void setUp(){
		try {
			vancouver = new SphericCoordinate(49.11, -123.11, radius);
			nuremberg = new SphericCoordinate(49.29,11.04, radius);
			p1 = new CartesianCoordinate(0.0, 0.0, 0.0);
			p2 = new CartesianCoordinate (10.0, 15.0, 20.0);
			test = new CartesianCoordinate(1.0,2.0,3.0);
			} catch (CoordinateException c) {
			c.printStackTrace();
		}
}
	
	
	//testing if Vancouver is not null
	@Test()
	public void test(){
	assertNotNull(vancouver);
	}
	
	@Test()
	public void testtype(){
		assertEquals(vancouver instanceof SphericCoordinate,true);
	}
	
	//testing if distance is calculuted properly
	@Test()
	public void testGetDistanceSpheric() throws CoordinateException{
		double distance_hard = 7668;	
		double distance_methode = vancouver.getDistance(nuremberg);
		assertEquals(distance_hard, distance_methode,0.5);
		
	}
	
	//testing if distance calculation is independet of order
	@Test()
	public void testOrder() throws CoordinateException{
		double distance1 = vancouver.getDistance(nuremberg);
		double distance2 = nuremberg.getDistance(vancouver);
		assertEquals(distance1, distance2, 0.1);
	}
	
	//testing if distance between same points is 0
	@Test()
	public void testEquals() throws CoordinateException{
		double distance1 = vancouver.getDistance(vancouver);
		assertEquals(distance1,0,0.0);
		
	}
	
	@Test()
	public void testGetLatitude(){
		double latitude_methode = vancouver.getLatitude();
		double latitude_hard = 49.11;
		assertEquals(latitude_methode, latitude_hard, 0.1);
	}
	
	@Test()
	public void testGetLondigute(){
		double longitude_method = vancouver.getLongitude();
		double longitude_hard = -123.11;
		assertEquals(longitude_method, longitude_hard, 0.1);
	}
	
	
	@Test()
	public void testCartesianConstructorAndGetters(){
		assertEquals(test.getX(),1.0, 0.0);
		assertEquals(test.getY(),2.0, 0.0);
		assertEquals(test.getZ(),3.0, 0.0);
		
	}
	
	@Test()
	public void testGetDistanceCartesian() throws CoordinateException{
		assertEquals(p1.getDistance(p2), Math.sqrt(725),0.1);
	}
	
	@Test()
	public void testTransformatinToCartesian() throws CoordinateException{
		SphericCoordinate test = new SphericCoordinate (0.0,0.0, radius);
		CartesianCoordinate transfered = new CartesianCoordinate (test.asCartesianX(), test.asCartesianY(), test.asCartesianZ());
		//expected cartesian coordinates (radius,0.0,0.0);
		assertEquals(transfered.getX(), radius,0.0);
		assertEquals(transfered.getY(), 0.0,0.0);
		assertEquals(transfered.getZ(), 0.0,0.0);
	}

	@Test (expected = CoordinateException.class)
	public void testpreconditionspherical () throws CoordinateException{
		SphericCoordinate fail1 = new SphericCoordinate (-100, 21,10);
		SphericCoordinate fail2 = new SphericCoordinate (21, 200, 23);
		SphericCoordinate fail3 = new SphericCoordinate (87,20,-1);
	}
	
	@ Test (expected = CoordinateException.class)
	public void getDistancePreCon() throws CoordinateException{
		double distance = vancouver.getDistance(null);
	}
	
	@Test (expected = CoordinateException.class)
	public void isEqualPreCon() throws CoordinateException{
		boolean fail = vancouver.isEqual(null);

	}
}
