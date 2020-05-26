import java.awt.geom.Rectangle2D.Double;

public class Mandelbrot extends FractalGenerator {

    	public static final int MAX_ITERATIONS = 2000;
    	public Mandelbrot() {
    		// TODO Auto-generated constructor stub
    	}

    	@Override
    	public void getInitialRange(Double range) {
    		range.x = -2;
    		range.y = -1.5;
    		range.width = 3;
    		range.height = 3;
    	}

    	@Override
    	public int numIterations(double x, double y) {
    		
    		int iter = 0;
    		Compl c = new Compl(x,y);
    		Compl z = new Compl();
    		while (true)
    		{
    			z.Squaring();
    			z.AddComlp(c);
    			iter++;
    			if (z.SquarModul()>4) return iter;
    			if (iter>MAX_ITERATIONS) return -1;
    		}
    	}
    }
