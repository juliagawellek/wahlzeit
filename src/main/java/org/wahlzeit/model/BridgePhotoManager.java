package org.wahlzeit.model;

/**
 * A photo manager provides access to and manages photos.
 */

public class BridgePhotoManager extends PhotoManager{
	

	protected static final BridgePhotoManager instance = new BridgePhotoManager();


	public BridgePhotoManager(){
		super();
	}
	

}
