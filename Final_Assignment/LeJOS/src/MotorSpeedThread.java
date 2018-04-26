import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class MotorSpeedThread extends Thread {
	public MotorSpeedThread() {
		this.setDaemon(true);
	}
	
	public void run() {
		while (true) {
			getCurrentMotorSpeeds();
			Main.movementDirection = getCurrentDirection();			
//			LCD.clear();
//			LCD.drawString(Main.movementDirection, 0, 4);
		}
	
	}
	
	public void getCurrentMotorSpeeds() {
		Main.leftMotorCurrentSpeed = Motor.A.getRotationSpeed();
		Main.rightMotorCurrentSpeed = Motor.B.getRotationSpeed();
	}
	
	public String getCurrentDirection() {
		int totalSpeed = Main.leftMotorCurrentSpeed + Main.rightMotorCurrentSpeed;

		if (totalSpeed > 0) {
			if (Main.rightMotorCurrentSpeed > Main.leftMotorCurrentSpeed) {
				return("FL");
			} else if (Main.rightMotorCurrentSpeed < Main.leftMotorCurrentSpeed) {
				return ("FR");
			} else {
				return ("F");
			}			
		} else if (totalSpeed < 0) {
			if (Main.rightMotorCurrentSpeed > Main.leftMotorCurrentSpeed) {
				return("BL");
			} else if (Main.rightMotorCurrentSpeed < Main.leftMotorCurrentSpeed) {
				return ("BR");
			} else {
				return ("B");
			}			
		} else {
			if (Main.leftMotorCurrentSpeed < 0 && Main.rightMotorCurrentSpeed > 0) {
				return "TL";
			} else if (Main.leftMotorCurrentSpeed > 0 && Main.rightMotorCurrentSpeed < 0) {
				return "TR";
			}
			
			return "S";
		}
				
				
	}
}
