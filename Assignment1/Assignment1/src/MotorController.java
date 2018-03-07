import lejos.hardware.motor.Motor;
import lejos.utility.Delay;
import lejos.hardware.lcd.LCD;

public class MotorController {
	
	private static double wheelDiameter = 43.2;
	private static double wheelDistanceFromCenter = 63;
	private static double wheelWidth = 22;
	private static int motorOffset = 1;
	private static double wheelCircumference = wheelDiameter * Math.PI;
	
	public static void logMessage(String message) {
		LCD.drawString(message, 0, 0);
		Delay.msDelay(5000);
	}
	
	public static void moveForward(double distance, int speed) {
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		int degree = calculateDegree(distance);
		Motor.A.rotateTo(degree, true);
		Motor.B.rotateTo(degree, true);
		while(Motor.A.isMoving()) Thread.yield();
	}
	
	private static int calculateDegree(double distance) {
		double degree = distance / wheelCircumference * 360;
		double degreeRounded = Math.round(degree);
		return (int)degreeRounded;
	}
	
	public static void turnLeft(double xAxis, double yAxis, int speed) {
		
	}
	
	public static void turnRight(double xAxis, double yAxis, int speed) {
		
	}
	
	public static void rotate(double angle, int speed) {
		
	}
}
