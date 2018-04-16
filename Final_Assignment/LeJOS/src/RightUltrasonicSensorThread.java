import lejos.hardware.sensor.NXTUltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.*;

public class RightUltrasonicSensorThread extends Thread {

	public static NXTUltrasonicSensor UltrasonicSensor;
	SampleProvider ultrasonicDistanceProvider;
	
	public RightUltrasonicSensorThread() {
		UltrasonicSensor = new NXTUltrasonicSensor(SensorPort.S2);
		ultrasonicDistanceProvider = UltrasonicSensor.getDistanceMode();
		this.setDaemon(true);
	}
	
	  public void run() {
		  while(true){
		      float [] sample = new float[ultrasonicDistanceProvider.sampleSize()] ;
		      ultrasonicDistanceProvider.fetchSample(sample, 0);
		      float rightUltrasonicDistance = sample[0];
//		      LCD.drawString(Float.toString(rightUltrasonicDistance), 0, 2);
		  }
	  }
	
}
