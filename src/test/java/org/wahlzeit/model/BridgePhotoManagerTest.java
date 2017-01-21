package org.wahlzeit.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

public class BridgePhotoManagerTest {
		
	@ClassRule
	public static TestRule chain = RuleChain.
			outerRule(new LocalDatastoreServiceTestConfigProvider()).
			around(new RegisteredOfyEnvironmentProvider());
	/**
	 * adding bridge-photos
	 * @throws IOException
	 */
	@Test()
	public void testadd () throws IOException{
		Bridge goldengate = new Bridge(new BridgeType("Highway Bridge"), "Golden Gate Bridge", "San Francisco", 2737, 1937);
		BridgePhoto bridge = new BridgePhoto(new PhotoId(123), goldengate);
		BridgePhotoManager.getInstance().addPhoto(bridge);
		assertEquals(BridgePhotoManager.getInstance().getPhoto(new PhotoId(123)), bridge);
	}

}
