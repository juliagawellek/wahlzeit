package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
		patternName = {"AbstractFactory", "Singleton"},
		participants = {"ConcreteFactory", "Singleton"
		}
)

public class BridgePhotoFactory extends PhotoFactory{
	
	private static final Logger log = Logger.getLogger(BridgePhotoFactory.class.getName());
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
    static {
        instance = new BridgePhotoFactory();
    }
	
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}
	
	/**
	 * @methodtype factory
	 */
	@Override
	public BridgePhoto createPhoto() {
		return new BridgePhoto();
	}
	
	/**
	 * Creates a new photo with the specified id
	 */
	@Override
	public BridgePhoto createPhoto(PhotoId id) {
		if (id == null){
			throw new IllegalArgumentException ("id must not be null!");
		}
		return new BridgePhoto(id);
	}


}
