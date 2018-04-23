import lejos.hardware.sensor.NXTUltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.*;

public class LeftUltrasonicSensorThread extends Thread {

	public static NXTUltrasonicSensor UltrasonicSensor;
	SampleProvider ultrasonicDistanceProvider;
	
	public LeftUltrasonicSensorThread() {
		UltrasonicSensor = new NXTUltrasonicSensor(SensorPort.S1);
		ultrasonicDistanceProvider = UltrasonicSensor.getDistanceMode();
		this.setDaemon(true);
	}
	
	  public void run() {
		  while(true){
		      float [] sample = new float[ultrasonicDistanceProvider.sampleSize()] ;
		      ultrasonicDistanceProvider.fetchSample(sample, 0);
		      Main.leftUltrasonicDistance = sample[0];
		      //System.out.println(Main.leftUltrasonicDistance);
		  }
	  }
	
}
