package org.wahlzeit.model;

public class Bridge {

	private BridgeType bridgeType;
	private final String owner;
	
	public Bridge(BridgeType bridgeType, String owner){
		this.bridgeType = bridgeType;
		this.owner = owner;
		
		assertClassInvariants();
	}
	
	private void assertClassInvariants(){
		if (bridgeType == null || owner == null){
			throw new IllegalArgumentException ("BridgePhoto cannot be instanciated");
		}
	}
	
	public BridgeType getType() {
		return bridgeType;
	}

	public String getOwner(){
		return owner;
	}
	
}
