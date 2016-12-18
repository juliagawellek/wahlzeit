package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class LocationTest {

	private SphericCoordinate nuremberg;
	private Location location;
	
	@Before
	public void setUp(){
		try{
			nuremberg = SphericCoordinate.getInstance(49.29,11.04, 6371);
			location = new Location (nuremberg);
		} catch (CoordinateException c) {
			c.printStackTrace();
		}
	}
	//exception handling test
	@Test (expected = CoordinateException.class)
	public void testConstructor() throws CoordinateException{
		new Location(null);
	}
	
}
