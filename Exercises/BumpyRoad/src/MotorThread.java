import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;

public class MotorThread extends Thread {
	
	public MotorThread() {
		this.setDaemon(true);
	}
	
	public void run() {
		
		while(true) {
			
			synchronized(Main.countLockObject) {
				if(Main.beepCounter > 5) {
					Motor.A.setSpeed(100);
					Motor.B.setSpeed(100);
				} else {
					Motor.A.setSpeed(6000);
					Motor.B.setSpeed(6000);
				}
			}
			moveForward();
		}
		
	}
	
	private void moveForward() {

		Motor.A.forward();
		Motor.B.forward();
		
	}
}
