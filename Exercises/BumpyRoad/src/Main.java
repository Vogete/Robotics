import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.Button;
import lejos.robotics.SampleProvider;

public class Main {

	public static volatile int beepCounter = 0;
	public static Object countLockObject = new Object();
	
	public static void main(String[] args) {
		
		TouchSensorThread touchThread = new TouchSensorThread();
		MotorThread motorThread = new MotorThread();
		BeepPrinterThread printerThread = new BeepPrinterThread();
		BeepCounterThread counterThread = new BeepCounterThread();
		
		touchThread.start();
		motorThread.start();
		printerThread.start();
		counterThread.start();
		
		while(!Button.ESCAPE.isDown()) {
			try { 
				Thread.sleep(100);
				Motor.A.stop();
				Motor.B.stop();
			} 
			catch (InterruptedException e) { e.printStackTrace();}
		}
		Sound.setVolume(10);
	}
	
	
}
