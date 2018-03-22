import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;

public class MotorThread extends Thread {
	
	public MotorThread() {
		Motor.A.setSpeed(6000);
		Motor.B.setSpeed(6000);
		this.setDaemon(true);
	}
	
	public void run() {
		
		while(true) {
			moveForward();
		}
		
	}
	
	private void moveForward() {

		Motor.A.forward();
		Motor.B.forward();
		
	}
}
