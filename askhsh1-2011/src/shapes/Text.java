package shapes;
import java.awt.Color;
import java.awt.Graphics;


/**
 * The Class Text.
 */
public class Text extends Shape {

	/** The text position coordinates. */
	private int xt, yt;
	
	/** The text. */
	private String text;
	
	/**
	 * Instantiates a new text.
	 *

	@param g the g
	 */
	public Text(String text) {
		try {
			xt = (int)(Math.random()*700);
			yt = (int)(Math.random()*400);
			this.text = text;
		} catch (Exception e){
			System.err.println("Error: " + e.getMessage());
	    }
	}
	
	/**
	 * Draw the String.
	 *

	@param g the g
	 */
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawString(text, xt, yt);
	}
	
}
