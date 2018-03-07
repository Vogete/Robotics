import lejos.hardware.*;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class Assignment1 {
	public double WheelDiameter = 43.2;
	public double WheelDistanceFromCenter = 63;
	public double WheelWidth = 22;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCD.drawString("Hello! :)", 0, 4);
		Delay.msDelay(5000);
	}

}
