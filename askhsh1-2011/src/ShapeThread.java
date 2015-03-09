import java.util.List;

import shapes.*;

/**
 * The Class ShapeThread.
 */
public class ShapeThread extends Thread {
	
	/** The canvas. */
	public final Canvas canvas;
	
	/** The shape list. */
	private List<Shape> shapeList;

	/** The lock. */
	private Lock lock;
	
	/**
	 * Instantiates a new shape thread.
	 *

	@param canvas the canvas
	 * @param shapeList the shape list
	 * @param lock the lock
	 */
	public ShapeThread(Canvas canvas, List<Shape> shapeList, Lock lock) {
		this.lock = lock;
		this.shapeList = shapeList;
		this.canvas = canvas;
		this.setDaemon(true);
	}


	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		while (true){
			// Add new object and repaint
			Shape shape;
			if (canvas.getCircle())
				shape = new Circle();
			else
				shape = new Line();
			lock.lock();
			shapeList.add(shape);
			lock.unlock();
			canvas.repaint();
			
			// Sleep 1 second
			mySleep(1000);
			
			// Remove old object
			lock.lock();
			shapeList.remove(shapeList.indexOf(shape));
			lock.unlock();
		}
	}
	
	
	/**
	 * My sleep.
	 *

	@param time the time
	 */
	private void mySleep(int time) {
		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
