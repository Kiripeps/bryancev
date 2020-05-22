
public class Lab1 {
	public static void main(String[] args) {

		/** coordinate X first point **/
		double xCoord1 = Double.parseDouble(args[0]);
		/** coordinate Y first point **/
		double yCoord1 = Double.parseDouble(args[1]);
		/** coordinate Z first point **/
		double zCoord1 = Double.parseDouble(args[2]);
		/** coordinate X second point **/
		double xCoord2 = Double.parseDouble(args[3]);
		/** coordinate Y second point **/
		double yCoord2 = Double.parseDouble(args[4]);
		/** coordinate z second point **/
		double zCoord2 = Double.parseDouble(args[5]);
		/** coordinate X third point **/
		double xCoord3 = Double.parseDouble(args[6]);
		/** coordinate y third point **/
		double yCoord3 = Double.parseDouble(args[7]);
		/** coordinate Z third point **/
		double zCoord3 = Double.parseDouble(args[8]);
		/** initialization first point **/
		Point3d point1 = new Point3d(xCoord1,yCoord1,zCoord1);
		/** initialization second point **/
		Point3d point2 = new Point3d(xCoord2,yCoord2,zCoord2);
		/** initialization third point **/
		Point3d point3 = new Point3d(xCoord3,yCoord3,zCoord3);
		// Check if the points match
		if (TestEqual(point1,point2,point3)) System.out.println("Area of a triangle " + computeArea(point1,point2,point3));
		else System.out.println("Data entered incorrectly, some points match");
	}
	/** Method calculating the area of a triangle using the Heron formula**/
	public static double computeArea(Point3d point1,Point3d point2,Point3d point3)
	{
		// Calculation of the lengths of the sides of a triangle
		double a = point1.distanceTo(point2);
		double b = point1.distanceTo(point3);
		double c = point2.distanceTo(point3);
		//Half Perimeter Calculation
		double p = (a+b+c)/2;
		// Calculation of the area of a triangle
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
		
	}
	/** Method returning true if all points are different, otherwise false **/
	public static boolean TestEqual(Point3d point1, Point3d point2, Point3d point3)
	{
		if (point1.equals(point2)) return false;
		if (point1.equals(point3)) return false;
		if (point2.equals(point3)) return false;
		return true;
	}

}
