package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationTest {

	//exception handling test
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor1(){
		new Location(null);
	}
	
	@Test()
	public void testConstructor(){
		Coordinate Nuremberg = new Coordinate(49.29,11.04);
		Location location = new Location (Nuremberg);
		assertEquals(location.getCoordinate(), Nuremberg);
	}
}
