import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.*;

public class IRSensorThread extends Thread {

	public static EV3IRSensor IRSensor;
	SampleProvider infraRedDistanceProvider;
	
	public IRSensorThread() {
		IRSensor = new EV3IRSensor(SensorPort.S3);
		infraRedDistanceProvider = IRSensor.getMode("Distance");
		this.setDaemon(true);
	}
	
	  public void run() {
		  while(true){
		      float [] sample = new float[infraRedDistanceProvider.sampleSize()] ;
		      infraRedDistanceProvider.fetchSample(sample, 0);
		      Main.irDistance = sample[0];
		      //System.out.println(Main.irDistance);
		  }
	  }
	
}
