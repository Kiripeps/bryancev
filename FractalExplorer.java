import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class FractalExplorer extends JFrame {	

	private int size;	

	private JImageDisplay image;

	private FractalGenerator fg;

	private Rectangle2D.Double range;

	public FractalExplorer(int size) 
	{
		this.size = size;
		image = new JImageDisplay(size, size);
		fg = new Mandelbrot(); 
		range = new Rectangle2D.Double();
		fg.getInitialRange(range);
	}

	private void createAndShowGUI(){

	    this.setTitle("Fractal Explorer");
	    this.setSize(size, size);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.add(image);
	    JButton button = new JButton("Reset Display");
	    this.add(button, "South");
	    button.addActionListener(new ButtonEventListener());
	    image.addMouseListener(new MouseEventListener());
	    this.setVisible (true);
	    this.setResizable (false);  
	}

	private void drawFractal()
	{

		 for(int x = 0;x<this.size;x++)
		 {
			 for (int y = 0;y<this.size;y++)
			 {
				 double xCoord = FractalGenerator.getCoord (range.x, range.x + range.width,size, x);
				 double yCoord = FractalGenerator.getCoord (range.y, range.y + range.height,size, y);
				 int iter = this.fg.numIterations(xCoord,yCoord);
				 if (iter == -1) this.image.drawPixel(x, y, 0);
				 else 
				 {
					 int color = 16777216/2000*iter;
					 this.image.drawPixel(x, y, color);
				 }
					 
			 }
		 }
		 this.image.repaint();
	}
	class ButtonEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fg.getInitialRange(range);
			image.clearImage();
			drawFractal();
		}
	}
	class MouseEventListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			int xCoord =  e.getX();
			int yCoord = e.getY();
			double xCoor = FractalGenerator.getCoord(range.x, range.x + range.width,size, xCoord);
			double yCoor = FractalGenerator.getCoord(range.y, range.y + range.width,size, yCoord);
			fg.recenterAndZoomRange(range, xCoor, yCoor, 0.5);
			drawFractal();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}

	public static void main(String[] args) {
		FractalExplorer app = new FractalExplorer(800);
		app.createAndShowGUI();
		app.drawFractal();
		app.repaint();
	}
}