package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

public class BridgeManager {

	private static final BridgeManager instance = new BridgeManager();
	
	private HashMap<Bridge, Bridge> bridges = new HashMap<>();
	private Map<BridgeType, BridgeType>  bridgeTypes = new HashMap<>();
	
	//Singleton
	private BridgeManager(){
		
	}
	public static BridgeManager getInstance(){
		return instance;
	}
	
	public boolean containsBridge(Bridge bridge){
		return bridges.containsKey(bridge);
	}
	
	public Bridge getBridge (Bridge bridge){
		return bridges.get(bridge);
	}
	
	//instantiating domain class: Bridge
	//step1
	public synchronized Bridge createBridge (BridgeType type, String name, String city, int length, int year_built){
		//step 2
		Bridge bridge = new Bridge (type, name, city, length, year_built);
		bridges.put(bridge, bridge);
		return bridge;
	}
	
	public boolean containsBridgeType (BridgeType type){
		return bridgeTypes.containsKey(type);
	}
	
	public BridgeType getBridgeType (BridgeType type){
		return bridgeTypes.get(type);
	}
	
	public synchronized BridgeType createBridgeType(String type_function){
		BridgeType bridgeType = new BridgeType (type_function);
		bridgeTypes.put(bridgeType, bridgeType);
		return bridgeType;
	}
	
}
