package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

/**
 * 
 * Class for for creating bridge-photos and related objects.
 *
 */

public class BridgePhotoFactory extends PhotoFactory{
	
	private static final Logger log = Logger.getLogger(BridgePhotoFactory.class.getName());
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static BridgePhotoFactory instance = null;
	
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}

	/**
	 * Public singleton access method.
	 */
	public static synchronized BridgePhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic BridgePhotoFactory").toString());
			setInstance(new BridgePhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of BridgePhotoFactory.
	 */
	protected static synchronized void setInstance(BridgePhotoFactory BridgephotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize BridgePhotoFactory twice");
		}

		instance = BridgephotoFactory;
	}
	
	/**
	 * @methodtype factory
	 */
	public Photo createBridgePhoto() {
		return new BridgePhoto();
	}
	
	/**
	 * Creates a new photo with the specified id
	 */
	public Photo createBridgePhoto(PhotoId id) {
		return new BridgePhoto(id);
	}


}
