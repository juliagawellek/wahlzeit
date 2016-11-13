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
		BridgePhotoFactory factory = BridgePhotoFactory.getInstance();
		BridgePhoto bridge = (BridgePhoto) factory.createBridgePhoto((new PhotoId(123)));
		BridgePhoto bridge2 = (BridgePhoto) factory.createBridgePhoto();
		assertNotNull(factory);
		assertEquals(bridge.getClass(),BridgePhoto.class);
		
	}

}
