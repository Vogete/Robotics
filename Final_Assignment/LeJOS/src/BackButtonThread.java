import lejos.hardware.Button;

public class BackButtonThread extends Thread {

	public BackButtonThread() {
 
	}
	
	public void run() {
		while(!Button.ESCAPE.isDown()){
			Thread.yield();
		}

		System.exit(0);
	}
	
}
