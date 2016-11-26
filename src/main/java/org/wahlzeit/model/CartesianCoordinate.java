package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{
	
	private final double x;
	private final double y;
	private final double z;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param z
	 */
	public CartesianCoordinate (double x, double y, double z){
		this.x=x;
		this.y=y;
		this.z=z;
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
	
	@Override
	public CartesianCoordinate transferToCartesian(){
		return this;
	}
	
}
