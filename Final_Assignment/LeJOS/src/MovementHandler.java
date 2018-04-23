import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class MovementHandler {	
	static int speed = 500; 
	
	public MovementHandler() {	
		Motor.A.setAcceleration(2000);
		Motor.B.setAcceleration(2000);
		
	}
	
	public void resetMotorSpeeds() {
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		
	}
	
	public void forward() {		
		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
		Motor.A.startSynchronization();
		Motor.A.forward();
		Motor.B.forward();
		Motor.A.endSynchronization();
	}
	
	public void stopMovement() {
		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
		Motor.A.startSynchronization();
		Motor.A.stop();
		Motor.B.stop();
		Motor.A.endSynchronization();
		resetMotorSpeeds();
	}

	public void reduceMotorSpeed() {		
		Motor.A.setSpeed(Main.leftMotorCurrentSpeed - 50);
		Motor.B.setSpeed(Main.rightMotorCurrentSpeed - 50);		
	}
	

	public void backward() {		
		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
		Motor.A.startSynchronization();
		Motor.A.backward();
		Motor.B.backward();
		Motor.A.endSynchronization();
	}
	
	public void rotateLeft() {
		resetMotorSpeeds();
		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
		Motor.A.startSynchronization();
		Motor.A.backward();
		Motor.B.forward();
		Motor.A.endSynchronization();		
	}
	
	public void rotateRight() {
		resetMotorSpeeds();
		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
		Motor.A.startSynchronization();
		Motor.A.forward();
		Motor.B.backward();
		Motor.A.endSynchronization();
	}
	
	public void turnLeft(){
		
		if (Main.leftMotorCurrentSpeed > 0) {
			Motor.A.setSpeed(Main.leftMotorCurrentSpeed/2);
			forward();
		} else if (Main.rightMotorCurrentSpeed == 0 && Main.leftMotorCurrentSpeed == 0) {
			rotateLeft();
		} else {
			Motor.A.setSpeed(Main.leftMotorCurrentSpeed/2);
			backward();
		}
	}
	
	public void turnRight() {
		Motor.B.setSpeed(Main.rightMotorCurrentSpeed/2);
		
		if (Main.movementDirection.equals("F")) {
			forward();
		} else if (Main.movementDirection.equals("S")) {
			rotateRight();
		} else {
			backward();
		}		
	}
	
	public void endTurn() {
		if (Main.movementDirection.equals("FL") || Main.movementDirection.equals("FR")) {			
			resetMotorSpeeds();
			forward();
		} else if (Main.movementDirection.equals("BL") || Main.movementDirection.equals("BR")) {
			resetMotorSpeeds();
			backward();
		} else if (Main.movementDirection.equals("TL") || Main.movementDirection.equals("TR")) {
			resetMotorSpeeds();
			stopMovement();
		}
			
	}
	
}
