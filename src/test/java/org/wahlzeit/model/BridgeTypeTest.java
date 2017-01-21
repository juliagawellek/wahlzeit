package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

public class BridgeTypeTest {
	
	@ClassRule
	public static TestRule chain = RuleChain.
			outerRule(new LocalDatastoreServiceTestConfigProvider()).
			around(new RegisteredOfyEnvironmentProvider());
	
	
	String bridge_type = "Highway Bridge";
	Bridge goldengate;
	
	BridgeManager bridgeManager = BridgeManager.getInstance();
	
	
	@Test()
	public void testBridgeConstructor(){
		String name = "Golden Gate Bridge";
		String city = "San Francisco";
		int length = 2737;
		int year_built = 1937;
		goldengate = new Bridge(new BridgeType(bridge_type), name, city, length, year_built);
		
		assertEquals(goldengate.getBridgeType(),new BridgeType(bridge_type) );
		assertEquals(goldengate.getName(), name);
		assertEquals(goldengate.getCity(), city);
		assertEquals(goldengate.getLength_m(), length);
		assertEquals(goldengate.getYear_built(), year_built);
		
	}
	@Test()	
	public void TypeTest(){
		BridgeType type1 = bridgeManager.createBridgeType(bridge_type);
		BridgeType type2 = bridgeManager.createBridgeType(bridge_type);
		assertTrue(type1==type2);
	}
	
	@Test
	public void BridgeTest(){
		String name = "Golden Gate Bridge";
		String city = "San Francisco";
		int length = 2737;
		int year_built = 1937;
		Bridge gg1 = bridgeManager.createBridge(new BridgeType(bridge_type), name, city, length, year_built);
		Bridge gg2 = bridgeManager.createBridge(new BridgeType(bridge_type), name, city, length, year_built);
		assertTrue(gg1==gg2);
	}
}
