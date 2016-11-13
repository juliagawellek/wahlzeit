package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * A photo manager provides access to and manages photos.
 */

public class BridgePhotoManager extends PhotoManager{
	
	/**
	 *
	 */
	protected static final BridgePhotoManager instance = new BridgePhotoManager();

	private static final Logger log = Logger.getLogger(BridgePhotoManager.class.getName());

	public BridgePhotoManager(){
		super();
	}
	

}
