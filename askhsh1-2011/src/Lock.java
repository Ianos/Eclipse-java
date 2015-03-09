/**
 * The Class Lock.
 * It is highly recommended to use this lock so as 
 * the shapeList is not accessed and modified
 * simultaneously by more than one thread.
 */
public class Lock {

	/** The isLocked flag. */
	private boolean isLocked = false;

	/**
	 * Lock.
	 */
	public synchronized void lock() {
		while(isLocked){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isLocked = true;
	}

	/**
	 * Unlock.
	 */
	public synchronized void unlock(){
		isLocked = false;
		notify();
	}
}