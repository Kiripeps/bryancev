import java.awt.geom.Rectangle2D.Double;

public class Tricorn extends FractalGenerator {

    	public static final int MAX_ITERATIONS = 2000;
    	public Tricorn() {
    		// TODO Auto-generated constructor stub
    	}

    	@Override
    	public void getInitialRange(Double range) {
    		range.x = -2;
    		range.y = -2;
    		range.width = 4;
    		range.height = 4;
    	}

    	@Override
    	public int numIterations(double x, double y) {

    		int iter = 0;

    		class1 c = new class1(x,y);
    	
    		class1 z = new class1();
    		while (true)
    		{
    			z.met6();
    			z.met3();
    			z.met5(c);
    			iter++;
    			if (z.met4()>4) return iter;
    			if (iter>MAX_ITERATIONS) return -1;
    		}
    	}

    	public String toString()
    	{
    		return "Tricorn";
    	}
    }
