package mypack;

public class myTimer implements Runnable {
	
	
	private int timeInterval =4000;
	private Canvas canvas;
	

	public myTimer(int timeInterval, Canvas canvas) {
		super();
		this.timeInterval = timeInterval;
		this.canvas = canvas;
	}


	@Override
	public void run() {
		try {
			System.out.println();
			Thread.sleep(timeInterval);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(" Thread has been interrupted.");
			return;
		}
		System.out.println(" Ade geia");
		canvas.reset();
		//afta pigainoun to kiklo stin default position
		// to pano ipologizei ta coordinates 
		canvas.repaint();
	}

}
