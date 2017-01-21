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
	
	@Test()
	public void testConstructor(){
	Bridge bridge = new Bridge(new BridgeType("Highway Bridge"), "Golden Gate Bridge", "San Francisco", 2737, 1937);
	PhotoId id = new PhotoId(123);
	BridgePhoto photo = new BridgePhoto(id, bridge);
	assertEquals(photo.getBridge(), bridge);
	assertEquals(photo.getId(), id);
	}
}
