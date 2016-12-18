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
	public CartesianCoordinate (double x, double y, double z) throws CoordinateException{
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
	 * 
	 * @param x
	 * @throws CoordinateException 
	 */
	public void setX(double x) throws CoordinateException {
		assertIsValidX(x);
		this.x = x;
	}

	/**
	 * 
	 * @param y
	 * @throws CoordinateException 
	 */
	public void setY(double y) throws CoordinateException {
		assertIsValidX(y);
		this.y = y;
	}

	/**
	 * 
	 * @param z
	 * @throws CoordinateException 
	 */
	public void setZ(double z) throws CoordinateException {
		assertIsValidX(z);
		this.z = z;
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
