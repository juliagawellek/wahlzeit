package org.wahlzeit.model;

import com.google.appengine.api.images.Image;

/**
 * A photo manager provides access to and manages photos.
 */

public class BridgePhotoManager extends PhotoManager{
	
	static  {
        instance = new BridgePhotoManager();
    }
}
