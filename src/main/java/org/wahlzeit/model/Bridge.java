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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bridgeType == null) ? 0 : bridgeType.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bridge other = (Bridge) obj;
		if (bridgeType == null) {
			if (other.bridgeType != null)
				return false;
		} else if (!bridgeType.equals(other.bridgeType))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bridge [bridgeType=" + bridgeType + ", owner=" + owner + "]";
	}

	public BridgeType getType() {
		return bridgeType;
	}

	public String getOwner(){
		return owner;
	}
	
}
