import java.util.List;

import shapes.*;

/**
 * The Class TextThread.
 */
public class TextThread  extends Thread {

	/** The canvas. */
	public final Canvas canvas;
	
	/** The shape list. */
	private List<Shape> shapeList;
	
	/** The selection area. */
	private SelectionArea selectionArea;
	
	/** The lock. */
	private Lock lock;


	/**
	 * Instantiates a new text thread.
	 *

	@param canvas the canvas
	 * @param shapeList the shape list
	 * @param selectionArea the selection area
	 * @param lock the lock
	 */
	public TextThread(Canvas canvas, List<Shape> shapeList, SelectionArea selectionArea, Lock lock) {
		this.lock = lock;
		this.canvas = canvas;
		this.shapeList = shapeList;
		this.selectionArea = selectionArea;
		this.setDaemon(true);
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		while (true){
			// Add new object and repaint
			Shape text = new Text(selectionArea.getTextArea());
			lock.lock();
			shapeList.add(text);
			lock.unlock();
			canvas.repaint();
			// Sleep 1 second
			mySleep(1000);
			
			// Remove object and repaint
			shapeList.remove(shapeList.indexOf(text));
			canvas.repaint();
			// Sleep 1 second
			mySleep(1000);
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
