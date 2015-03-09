package iprog2;

public class MyThread extends Thread {
	
	public final Canvas canvas1;

	public MyThread(Canvas canvas) {
		this.canvas1 = canvas;
		this.setDaemon(true);
	}
	
	public void run(){
		while (true){
			try {
				System.out.println("going to sleep..");
				sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
				e.printStackTrace();
			}
			System.out.println("woke up");
			
			if (canvas1.isRed() == true)
				canvas1.changeCol(false);
			else
				canvas1.changeCol(true);
			canvas1.repaint();
		}
	}
}
