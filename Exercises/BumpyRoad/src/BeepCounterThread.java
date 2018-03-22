import lejos.hardware.motor.Motor;

public class BeepCounterThread extends Thread{
	public BeepCounterThread() {
		this.setDaemon(true);
	}
	
	public void run() {
		while(true) {
			//Wait 5 seconds before setting the counter to 0
			try { Thread.sleep(5000); } 
			catch (InterruptedException e) { e.printStackTrace();}
			
			synchronized(Main.countLockObject) {
				if(Main.beepCounter > 5) {
					Motor.A.setSpeed(100);
					Motor.B.setSpeed(100);
					Main.beepCounter = 0;
				} else {
					Motor.A.setSpeed(6000);
					Motor.B.setSpeed(6000);
				}
			}
		}
	}
}
