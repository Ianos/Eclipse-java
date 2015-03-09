import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import shapes.*;

/**
 * The Class Canvas.
 * @param <Shape>
 */
public class Canvas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The isCircle flag. */
	private boolean isCircle = true;

	/** The shapeList. */
	private List<Shape> shapeList;
	
	/** The lock. */
	private Lock lock;

	/**
	 * Instantiates a new canvas.
	 *

	@param selectionArea the selection area
	 * @param lock the lock
	 */
	public Canvas(List<Shape> shapeList, Lock lock) {
		this.lock = lock;
		this.shapeList = shapeList;
		setPreferredSize(new Dimension(800,450));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setOpaque(true);
	}


	/**
	 * Sets the circle.
	 *

	@param bool the new circle
	 */
	public void setCircle(boolean bool) {
		isCircle = bool;
	}


	/**
	 * Gets the circle.
	 *

	@return true, if successful
	 */
	public boolean getCircle() {
		return isCircle;
	}


	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){

		// Reset the canvas
		g.setColor(Color.red);
		g.fillRect (0, 0, getWidth(), getHeight());

		// Print all objects in the list
		lock.lock();
		Iterator<Shape> itr = shapeList.iterator();
	    while (itr.hasNext())
	      itr.next().draw(g);
	    lock.unlock();
	}
	
}
