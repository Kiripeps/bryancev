import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.imageio.ImageIO;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.File;
import java.io.IOException;

public class FractalExplorer extends JFrame {	

	private int size;	


	private JImageDisplay image;

	private FractalGenerator fg;

	private Rectangle2D.Double range;

	public FractalExplorer(int size) 
	{
		this.size = size;
		image = new JImageDisplay(size, size);
		range = new Rectangle2D.Double();
		fg  = new Mandelbrot();
		fg.getInitialRange(range);
	}

	private void createAndShowGUI(){

	    this.setTitle("Fractal Explorer");
	    this.setSize(size, size);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.add(image);
	    JButton rbutton = new JButton("Reset Display");
	    rbutton.setActionCommand("reset");
	    rbutton.addActionListener(new ActionEventListener());
	    JButton sbutton = new JButton("Save Button");
	    sbutton.setActionCommand("save");
	    sbutton.addActionListener(new ActionEventListener());
	    JPanel bpanel = new JPanel();
	    bpanel.add(rbutton);
	    bpanel.add(sbutton);
	    this.add(bpanel, "South");
	    image.addMouseListener(new MouseEventListener());
	    JComboBox box = new JComboBox();
	    box.addItem(new Mandelbrot());
	    box.addItem(new Tricorn());
	    box.addItem(new BurningShip());
	    box.addActionListener(new ActionEventListener());
	    JLabel label = new JLabel("Fractal:");
	    JPanel panel = new JPanel();
	    panel.add(label);
	    panel.add(box);
	    this.add(panel,"North");
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

					 int color = 2000*iter;
					 this.image.drawPixel(x, y, color);
				 }
					 
			 }
		 }
		 this.image.repaint();
	}
	class ActionEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() instanceof JComboBox)
			{
				JComboBox box = (JComboBox)e.getSource();
				fg = (FractalGenerator)box.getSelectedItem();
				fg.getInitialRange(range);
				image.clearImage();
				drawFractal();	
			}

			else if(((JButton)e.getSource()).getActionCommand() == "save")
			{
				JFrame jf = (JFrame)(((JButton)e.getSource()).getParent().getParent().getParent().getParent().getParent());
				JFileChooser fc = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
				fc.setFileFilter(filter);
				fc.setAcceptAllFileFilterUsed(false);
				if(fc.showSaveDialog(jf) != fc.APPROVE_OPTION) System.out.println("Отмена сохранения");
				else
				{
					File f = fc.getSelectedFile();
					try {
						ImageIO.write(image.bImage, "png", f);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(jf, e1.getMessage(), "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				
			}

			else
			{
				fg.getInitialRange(range);
				image.clearImage();
				drawFractal();	
			}
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
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
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