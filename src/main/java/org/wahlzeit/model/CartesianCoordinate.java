package org.wahlzeit.model;

import java.util.HashMap;

public class CartesianCoordinate extends AbstractCoordinate{
	
	private final double x;
	private final double y;
	private final double z;
	
	private static HashMap<Integer, CartesianCoordinate> cartesianInstances = new HashMap<>();
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param z
	 */
	private CartesianCoordinate (double x, double y, double z) throws CoordinateException{
		try{
		assertIsValidX(x);
		assertIsValidY(y);
		assertIsValidZ(z);
		} catch (CoordinateException c){
			throw new CoordinateException("CartesianCoordinate cannot be instanciated", c);
		}
		this.x=x;
		this.y=y;
		this.z=z;
		
		assertClassInvariants();
	}
	
	/**
	 * returns cartesian coords with given values.
	 * If instance with given values does not exist, it is inserted into the hashmap and is returned
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 * @throws CoordinateException
	 */
	public static CartesianCoordinate getInstance (double x, double y, double z) throws CoordinateException{
		CartesianCoordinate cartCoord = new CartesianCoordinate (x,y,z);
		synchronized (cartesianInstances){
			if (!cartesianInstances.containsValue(cartCoord)){
				cartesianInstances.put(cartCoord.hashCode(), cartCoord);
			}
			return cartesianInstances.get(cartCoord);
		}
	}
	
	/**
	 * 
	 * @return x
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * 
	 * @return y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * 
	 * @return z
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * assserts whether x is NaN
	 * @param x
	 * @throws CoordinateException
	 */
	private void assertIsValidX(double x) throws CoordinateException{
		if (Double.isNaN(x)){
			throw new CoordinateException ("x must not be NaN!");
		}
	}
	
	/**
	 * assserts whether y is NaN
	 * @param y
	 * @throws CoordinateException
	 */
	private void assertIsValidY(double y) throws CoordinateException{
		if (Double.isNaN(y)){
			throw new CoordinateException ("y must not be NaN!");
		}
	}
	
	/**
	 * assserts whether z is NaN
	 * @param z
	 * @throws CoordinateException
	 */
	private void assertIsValidZ(double z) throws CoordinateException{
		if (Double.isNaN(z)){
			throw new CoordinateException ("z must not be NaN!");
		}
	}
	
	/**
	 * asserts that x,y,z are not NaN
	 * @throws CoordinateException
	 */
	private void assertClassInvariants() throws CoordinateException{
		assertIsValidX(x);
		assertIsValidY(y);
		assertIsValidZ(z);
	}
	@Override
	public double asCartesianX() {
		return getX();
	}

	@Override
	public double asCartesianY() {
		return getY();
	}

	@Override
	public double asCartesianZ() {
		return getZ();
	}
	
}
