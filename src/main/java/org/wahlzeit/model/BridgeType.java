package org.wahlzeit.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class BridgeType {

//	private String name;
//	private String city;
//	private int length_m; //length in meters
//	private int year_built;
	
	//Definiert art von Brücke: autobahnbrücke, eisenbahnbrücke oder fußgängerbrücke
	private String type_function;
	
	private BridgeType superType = null;
	private Set<BridgeType> subTypes = new HashSet<BridgeType>();
	
	public BridgeType (String type){
		assertClassInvariants();
		this.type_function = type;
	}
	
	private void assertClassInvariants(){
		if (type_function == null){
			throw new IllegalArgumentException ("Bridge Type may not be null");
		}
	}
	
	public void setSuperType(BridgeType bridgeType){
		superType = bridgeType;
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
	
	public Iterator <BridgeType> getSubTypesIterator(){
		return subTypes.iterator();
	}
	
	public void addSubType (BridgeType type){
		type.setSuperType(type);
		subTypes.add(type);
	}
	
	public boolean removeSubType (Bridge type){
		return subTypes.remove(type);
	}
	
	public String getType(){
		return type_function;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subTypes == null) ? 0 : subTypes.hashCode());
		result = prime * result + ((superType == null) ? 0 : superType.hashCode());
		result = prime * result + ((type_function == null) ? 0 : type_function.hashCode());
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
		BridgeType other = (BridgeType) obj;
		if (subTypes == null) {
			if (other.subTypes != null)
				return false;
		} else if (!subTypes.equals(other.subTypes))
			return false;
		if (superType == null) {
			if (other.superType != null)
				return false;
		} else if (!superType.equals(other.superType))
			return false;
		if (type_function == null) {
			if (other.type_function != null)
				return false;
		} else if (!type_function.equals(other.type_function))
			return false;
		return true;
	}
	
}
