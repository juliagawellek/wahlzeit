package org.wahlzeit.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class BridgeManager {

	private static final BridgeManager instance = new BridgeManager();
	
	private Set<Bridge> bridges = new HashSet<>();
	private Map<String, BridgeType>  bridgeTypes = new HashMap<String, BridgeType>();
	
	public static BridgeManager getInstance(){
		return instance;
	}
	
	public synchronized BridgeType getType (String name, String city, int length, int year_built){
		BridgeType bridgeType = new BridgeType(name, city, length, year_built);
		BridgeType result = bridgeTypes.get(bridgeType);
		return result;
	}
	
	public Bridge createBridge (String name, String city, int length, int year_built, String owner){
		BridgeType bridgeType = new BridgeType(name, city, length, year_built);
		Bridge bridge = bridgeType.createBridge(owner);
		bridges.add(bridge);
		return bridge;
	}
	
}
