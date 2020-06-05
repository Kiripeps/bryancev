
public class Task2 {
	
	public static void main(String[] args) {
		 System.out.println(fZ("all zip files are beatifull, but we are zipped they"));
	     System.out.println(fZ("all zip files are compzipsed"));
	}
	 private static int fZ(String s) {
	        if (s.lastIndexOf("zip") != s.indexOf("zip") && s.indexOf("zip") != -1)
	            return s.lastIndexOf("zip");
	        return -1;
	    }
}
