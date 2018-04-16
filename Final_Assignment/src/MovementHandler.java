import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class MovementHandler {
	static int speed; 
	
	public MovementHandler() {
		MovementHandler.speed = 6000;
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Motor.A.setAcceleration(2000);
		Motor.B.setAcceleration(2000);
		
	}
	
	public void forward() {
		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
		Motor.A.startSynchronization();
		Motor.A.forward();
		Motor.B.forward();
		Motor.A.endSynchronization();		
	}
	
	public void stopMovement() {
		LCD.drawString("stop1", 0, 0);

		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
		Motor.A.startSynchronization();
		Motor.A.stop();
		Motor.B.stop();
		Motor.A.endSynchronization();
		
		LCD.drawString("stop2", 0, 1);
	}

	public void reduceMotorSpeed() {
		Motor.A.setSpeed(Motor.A.getSpeed() - 500);
		Motor.B.setSpeed(Motor.B.getSpeed() - 500);		
	}
	

	public void backward() {
		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
		Motor.A.startSynchronization();
		Motor.A.backward();
		Motor.B.backward();
		Motor.A.endSynchronization();
	}
	
	
}
