package org.wahlzeit.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SphericAndCartesianCoordinateTest {
	
	private double radius = 6371.0; //kilometers 
	private SphericCoordinate Vancouver  = new SphericCoordinate(49.11, -123.11, radius);
	private SphericCoordinate Nuremberg = new SphericCoordinate(49.29,11.04, radius);
	private CartesianCoordinate p1 = new CartesianCoordinate(0.0, 0.0, 0.0);
	private CartesianCoordinate p2 = new CartesianCoordinate (10.0, 15.0, 20.0);
	
	
	//testing if Vancouver is not null
	@Test()
	public void test(){
	assertNotNull(Vancouver);
	}
	
	@Test()
	public void testtype(){
		assertEquals(Vancouver instanceof SphericCoordinate,true);
	}
	
	//testing if distance is calculuted properly
	@Test()
	public void testGetDistanceSpheric(){
		double distance_hard = 7668;	
		double distance_methode = Vancouver.getDistance(Nuremberg);
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
	
	@Test()
	public void testGetLondigute(){
		double longitude_method = Vancouver.getLongitude();
		double longitude_hard = -123.11;
		assertEquals(longitude_method, longitude_hard, 0.1);
	}
	
	
	@Test()
	public void testCartesianConstructorAndGetters(){
		CartesianCoordinate test = new CartesianCoordinate(1.0,2.0,3.0);
		assertEquals(test.getX(),1.0, 0.0);
		assertEquals(test.getY(),2.0, 0.0);
		assertEquals(test.getZ(),3.0, 0.0);
		
	}
	
	@Test()
	public void testGetDistanceCartesian(){
		assertEquals(p1.getDistance(p2), Math.sqrt(725),0.1);
	}
	
	@Test()
	public void testTransformatinToCartesian(){
		SphericCoordinate test = new SphericCoordinate (0.0,0.0, radius);
		CartesianCoordinate transfered = new CartesianCoordinate (test.asCartesianX(), test.asCartesianY(), test.asCartesianZ());
		//expected cartesian coordinates (radius,0.0,0.0);
		assertEquals(transfered.getX(), radius,0.0);
		assertEquals(transfered.getY(), 0.0,0.0);
		assertEquals(transfered.getZ(), 0.0,0.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testpreconditionspherical (){
		SphericCoordinate fail1 = new SphericCoordinate (-100, 21,10);
		SphericCoordinate fail2 = new SphericCoordinate (21, 200, 23);
		SphericCoordinate fail3 = new SphericCoordinate (87,20,-1);
	}
	
	@ Test(expected = IllegalArgumentException.class)
	public void getDistancePreCon(){
		double distance = Vancouver.getDistance(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isEqualPreCon(){
		boolean fail = Vancouver.isEqual(null);
	}
}
