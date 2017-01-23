package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import com.googlecode.objectify.annotation.Subclass;

/**
 * 
 * BridgePhoto is a subclass of Photo, in which attributes of the bridge depicted in the picture are set
 *
 */

@PatternInstance(
		patternName = {"AbstractFactory"},
		participants = {"ConcreteProduct"}
		
)

@Subclass
public class BridgePhoto extends Photo{


	private Bridge bridge;
	
	/**
	 * constructor
	 */
	public BridgePhoto() {
		super();
	}
	
	/**
	 * constructor
	 * @param myId
	 */
	public BridgePhoto(PhotoId myId) {
		super(myId);
	}
	
	/**
	 * constructor
	 * @param myId
	 */
	public BridgePhoto(PhotoId myId, Bridge bridge) {
		super(myId);
		this.bridge=bridge;
	}
	
	public Bridge getBridge(){
		return bridge;
	}
}	



