package org.wahlzeit.model;

public class Bridge {

	private BridgeType bridgeType;
	
	//Attribute, die spezifische Brücke ausmachen
	private String name;
	private String city;
	private int length_m; //length in meters
	private int year_built;
	
	
	public Bridge(BridgeType bridgeType, String name, String city, int length_m, int year_built){
		this.bridgeType = bridgeType;
		this.name = name;
		this.city = city;
		this.length_m = length_m;
		this.year_built = year_built;
		
		assertClassInvariants();
	}
	

	private void assertClassInvariants(){
		if (bridgeType == null ||name == null || city == null || length_m<0 || year_built<0){
			throw new IllegalArgumentException ("BridgePhoto cannot be instanciated");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bridgeType == null) ? 0 : bridgeType.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + length_m;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year_built;
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
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (length_m != other.length_m)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year_built != other.year_built)
			return false;
		return true;
	}

	public BridgeType getBridgeType() {
		return bridgeType;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public int getLength_m() {
		return length_m;
	}

	public int getYear_built() {
		return year_built;
	}

}
