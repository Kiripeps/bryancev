
public class Point3d {

	/** coordinate X **/
	private double xCoord;
	/** coordinate Y **/
	private double yCoord;
	/** coordinate Z **/
	private double zCoord;
	/** initialization constructor **/
	public Point3d ( double x, double y, double z) 
	{
		xCoord = x;
		yCoord = y;
		zCoord = y;
	}
	/** initialization constructor. **/
	public Point3d () 
	{
	//Call constructor with three parameters and define source.
		this(0, 0, 0);
	}
	/** Return coordinate X **/
	public double getX() 
	{
		return xCoord;
	}
	/** Return coordinate Y **/
	public double getY() 
	{
		return yCoord;
	}
	/** Return coordinate Z **/
	public double getZ() 
	{
		return zCoord;
	}
	/** setting value coordinate X. **/
	public void setX ( double val) 
	{
		xCoord = val;
	}
	/** setting value coordinate Y. **/
	public void setY (double val) 
	{
		yCoord = val;
	}
	/** setting value coordinate Z. **/
	public void setZ (double val) 
	{
		zCoord = val;
	}
	 public boolean equals(Point3d val)
	 {
		 if (this.xCoord!= val.getX()) return false;
		 if (this.yCoord!= val.getY()) return false;
		 if (this.zCoord!= val.getZ()) return false;
		 return true;
	 }
	 public double distanceTo(Point3d val)
	 {
		 return Math.sqrt(Math.pow(this.xCoord-val.getX(),2)+Math.pow(this.yCoord-val.getY(),2)+Math.pow(this.zCoord-val.getZ(),2));
	 }
}
