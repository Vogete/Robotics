import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

public class TouchSensorThread extends Thread{

	EV3TouchSensor touch;	    
	SampleProvider touched;
	
	public TouchSensorThread() {
		touch = new EV3TouchSensor(SensorPort.S1);	    
		touched = touch.getTouchMode();
		this.setDaemon(true);
	}

	public void run() {
		float[] sample = new float[touched.sampleSize()];
		
	    Sound.setVolume(20);
	    
	    while(true){
	    
	    	touched.fetchSample(sample,0);
	    	int t = (int) sample[0];    	
	    	if(t == 1) {
	    		Sound.beep();
	    		synchronized(Main.countLockObject){
	    			Main.beepCounter++;
	    		}
	    		
	    	}
	    }
	}
}
