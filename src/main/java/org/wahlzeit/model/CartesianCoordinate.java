package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{
	
	private double x;
	private double y;
	private double z;
	
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
