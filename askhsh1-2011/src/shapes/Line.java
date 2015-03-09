package shapes;
import java.awt.Color;
import java.awt.Graphics;


/**
 * The Class Line.
 */
public class Line extends Shape {

	/** The line coordinates. */
	private int x0, y0, x1, y1;
	
	/**
	 * Instantiates a new line.
	 *

	@param g the g
	 */
	public Line() {
		x0 = (int)(Math.random()*800);
		x1 = (int)(Math.random()*800);
		y0 = (int)(Math.random()*450);
		y1 = (int)(Math.random()*450);
	}
	
	
	/**
	 * Draw the Line.
	 *

	@param g the g
	 */
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(x0, y0, x1, y1);
	}
	
}
