
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class JImageDisplay extends JComponent {
	public BufferedImage bImage;

	public JImageDisplay(int width, int height) {
		this.bImage = new BufferedImage(width,height,1);
		super.setPreferredSize(new java.awt.Dimension(width,height));
		
	}

	 @Override
	public void paintComponent(Graphics g)
	{	
		 super.paintComponents(g);
		 g.drawImage(this.bImage, 0, 0, this.bImage.getWidth(), this.bImage.getHeight(), null);
	}

	 public void clearImage()
	 {
		 for(int x = 0;x<this.bImage.getWidth();x++)
		 {
			 for (int y = 0;y<this.bImage.getHeight();y++)
			 {
				 this.bImage.setRGB(x, y, 0);
			 }
		 }
	 }
	 public void drawPixel(int x, int y, int rgbColor)
	 {
		 this.bImage.setRGB(x, y, rgbColor);
		 
	 }
}