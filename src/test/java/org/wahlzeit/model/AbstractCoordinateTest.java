package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AbstractCoordinateTest {
	
	private SphericCoordinate sp1 = new SphericCoordinate(1, 2, 3);
	private SphericCoordinate sp2 = new SphericCoordinate(4, 5, 6);
	private CartesianCoordinate sp2_cart = new CartesianCoordinate (5.962608107254586, 0.5216606144325431, 0.4185388424647518); //sp2 in cart
	private CartesianCoordinate ca1 = new CartesianCoordinate (0,0,0);
	private CartesianCoordinate ca2 = new CartesianCoordinate (2,4,6);
	
	@Test()
	public void testGetDistance(){
		//2 cartesian coords
		double distance1 = ca1.getDistance(ca2);
		double actualDistance1 = Math.sqrt(Math.pow((2-0), 2)+ Math.pow((4-0), 2) + Math.pow((6-0), 2));
		assertEquals(distance1, actualDistance1, 0);
		
		//2 spherical coords
		double distance2 = sp1.getDistance(sp2);
		double distance3 = sp1.getDistance(sp2);
		assertEquals(distance2, distance3, 0.1);
		
		//mixed
		double distance4 = sp2.getDistance(sp2_cart);
		assertEquals(distance4, 0.0,0.0);
		
	}
	
	@Test()
	public void testIsEqual() {
		//Spheric
		  SphericCoordinate sp = new SphericCoordinate(1, 2, 3);
		  boolean compare_true = sp.isEqual(sp1);
		  boolean compare_false = sp1.isEqual(sp2);
		  assertEquals(compare_true, true);
		  assertEquals(compare_false, false);
		  
		  //cartesian
		  CartesianCoordinate ca = new CartesianCoordinate (2,4,6);
		  boolean cart_comp_true = ca.isEqual(ca2);
		  boolean cart_comp_false = ca1.isEqual(ca2);
		  assertEquals(cart_comp_true, true);
		  assertEquals(cart_comp_false, false);
		  
		  //mixed
		  boolean mixed_comp_true = sp2.isEqual(sp2_cart);
		  boolean mixed_comp_false = sp2.isEqual(ca2);
		  assertEquals (mixed_comp_true, true);
		  assertEquals(mixed_comp_false, false);
	}
}
