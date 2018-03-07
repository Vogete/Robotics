import lejos.hardware.motor.Motor;
import lejos.utility.Delay;
import lejos.hardware.lcd.LCD;

public class MotorController {
	
	private static double wheelDiameter = 43.2;
	private static double wheelDistanceFromCenter = 63;
	private static double wheelWidth = 22;
	private static int motorOffset = 1;
	private static double wheelCircumference = wheelDiameter * Math.PI;
	private static double distanceBetweenWheels = 128;
	private static int acceleration = 2000;
	
	public static void logMessage(String message) {
		LCD.drawString(message, 0, 0);
		Delay.msDelay(5000);
	}
	
	public static void moveForward(double distance, int speed) {
		Motor.A.setAcceleration(acceleration);
		Motor.B.setAcceleration(acceleration);
		
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		int degree = calculateDegree(distance);
		Motor.A.rotateTo(degree, true);
		Motor.B.rotateTo(degree, true);
		while(Motor.A.isMoving()) Thread.yield();
		
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
	}
	
	private static int calculateDegree(double distance) {
		double degree = distance / wheelCircumference * 360;
		double degreeRounded = Math.round(degree);
		return (int)degreeRounded;
	}
	
	public static void turn(double turningDistance, int turningDegree, String direction) {
		turningDistance = turningDistance - wheelDistanceFromCenter;
		int time = 2; //seconds
		double wheelInnerSpeed = (2 * turningDistance * turningDegree) / (wheelDiameter * time);
		double wheelOuterSpeed = (2 * turningDegree * (turningDistance + distanceBetweenWheels))/(wheelDiameter * time);
		
		Motor.A.setAcceleration(acceleration);
		Motor.B.setAcceleration(acceleration);
		
		if(direction == "left") {
			Motor.A.setSpeed(Math.round(wheelInnerSpeed));
			Motor.B.setSpeed(Math.round(wheelOuterSpeed));
		} else if (direction == "right") {
			Motor.A.setSpeed(Math.round(wheelOuterSpeed));
			Motor.B.setSpeed(Math.round(wheelInnerSpeed));
		} else {
			//TODO: refactoring
		}
		
		Motor.A.forward();
		Motor.B.forward();
		
		try { Thread.sleep(time*1000); } catch(Exception e) {}
		
		Motor.A.stop(true);
		Motor.B.stop(true);
		
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
	}
	
	
	public static void rotate(double angle, int speed) {
		
	}
}
