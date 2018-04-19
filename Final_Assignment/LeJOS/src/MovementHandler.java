import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class MovementHandler {	
	static int speed = 500; 
	
	public MovementHandler() {	
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Motor.A.setAcceleration(2000);
		Motor.B.setAcceleration(2000);
		
	}
	
	public void forward() {		
		LCD.clear();
		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
		Motor.A.startSynchronization();
		Motor.A.forward();
		Motor.B.forward();
		Motor.A.endSynchronization();
	}
	
	public void stopMovement() {
//		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
//		Motor.A.startSynchronization();
		Motor.A.stop(true);
		Motor.B.stop(true);
//		Motor.A.endSynchronization();
				
	}

	public void reduceMotorSpeed() {
		MovementHandler.speed -= 50;
		Motor.A.setSpeed(MovementHandler.speed);
		Motor.B.setSpeed(MovementHandler.speed);		
	}
	

	public void backward() {
		Motor.A.synchronizeWith(new RegulatedMotor[]{Motor.B});
		Motor.A.startSynchronization();
		Motor.A.backward();
		Motor.B.backward();
		Motor.A.endSynchronization();
	}
	
	
	public void turnLeft(){
		int motorASpeed = Motor.A.getSpeed();
		int motorBSpeed = Motor.B.getSpeed();
		Motor.A.setSpeed(motorASpeed/2);
		forward();
	}
	
	public void turnRight() {
		int motorASpeed = Motor.A.getSpeed();
		int motorBSpeed = Motor.B.getSpeed();
		Motor.B.setSpeed(motorASpeed/2);
		forward();
	}
	
}
