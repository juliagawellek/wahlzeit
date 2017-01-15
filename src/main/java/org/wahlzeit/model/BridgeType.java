package org.wahlzeit.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class BridgeType {

	private String name;
	private String city;
	private int length_m; //length in meters
	private int year_built;
	
	private BridgeType superType = null;
	private Set<BridgeType> subTypes = new HashSet<BridgeType>();
	
	public BridgeType (String name, String city, int length, int year_built){
		this.name = name;
		this.city = city;
		this.length_m = length;
		this.year_built = year_built;
		
		assertClassInvariants();
	}
	
	private void assertClassInvariants(){
		if (name == null || city == null || length_m<0 || year_built<0){
			throw new IllegalArgumentException ("BridgePhoto cannot be instanciated");
		}
	}
	
	public Bridge createBridge (String owner){
		return new Bridge(this, owner);
	}
	

	public Iterator <BridgeType> GetSubTypesIterator(){
		return subTypes.iterator();
	}
	
	public boolean isSubtype (BridgeType other){
		BridgeType parent = this.superType;
		while (parent != null){
			if (parent==other){
				return true;
			}
			parent = parent.superType;
		}
		return false;
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

	public BridgeType getSuperType(){
		return superType;
	}
	
	public void setSuperType(BridgeType bridgeType){
		superType = bridgeType;
	}
}
