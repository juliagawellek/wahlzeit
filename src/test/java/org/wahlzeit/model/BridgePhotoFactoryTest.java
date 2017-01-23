package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

public class BridgePhotoFactoryTest {
	
		
	@ClassRule
	public static TestRule chain = RuleChain.
			outerRule(new LocalDatastoreServiceTestConfigProvider()).
			around(new RegisteredOfyEnvironmentProvider());
	
	/**
	 * testing if bridge factory works with bridge photos
	 */
	@Test()
	public void test(){
		BridgePhotoFactory factory = new BridgePhotoFactory();
		Bridge goldengate = new Bridge(new BridgeType("Highway Bridge"), "Golden Gate Bridge", "San Francisco", 2737, 1937);
		BridgePhoto bridge = factory.createPhoto((new PhotoId(123)));
		BridgePhoto bridge2 = factory.createPhoto();
		assertNotNull(factory);
		assertEquals(bridge.getClass(),BridgePhoto.class);
		
	}

}
