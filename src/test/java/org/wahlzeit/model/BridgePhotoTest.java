package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;


public class BridgePhotoTest {
	
	
	@ClassRule
	public static TestRule chain = RuleChain.
			outerRule(new LocalDatastoreServiceTestConfigProvider()).
			around(new RegisteredOfyEnvironmentProvider());
	
	/**
	 * testing setter and getter
	 */
	@Test()
	public void testPhotoAttributes(){
		BridgePhoto bridge1 = new BridgePhoto();
		bridge1.setBridgePhoto("Brooklyn Bridge", "New York", 1825, 1883);
		String name = bridge1.getName();
		assertEquals(name,"Brooklyn Bridge");
		
	}
	
	/**
	 * testing the constructor
	 */
	@Test()
	public void testConstructor(){
		BridgePhoto bridge1 = new BridgePhoto(new PhotoId(123));
		int photoid = 123;
		assertEquals(bridge1.getId().asInt(), photoid);
	}

}
