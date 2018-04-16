import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.hardware.port.*;
import java.awt.Color;

import lejos.hardware.lcd.LCD;

public class ColorSensorThread extends Thread {
	public static EV3ColorSensor ColorSensor;
	SampleProvider rgbColorProvider;
	
	public ColorSensorThread() {
		ColorSensor = new EV3ColorSensor(SensorPort.S4);
		rgbColorProvider = ColorSensor.getRGBMode();
		this.setDaemon(true);
	}
	
	public void run() {
		while (true) {
			float[] sample = new float[rgbColorProvider.sampleSize()];
			rgbColorProvider.fetchSample(sample, 0);
		
			float[] rgb = new float[sample.length];
			
			rgb[0] = sample[0]*100;
			rgb[1] = sample[1]*100;
			rgb[2] = sample[2]*100;
			
			float[] hsb = new float[rgb.length];
					
			Color.RGBtoHSB((int) rgb[0], (int)rgb[1], (int)rgb[2], hsb);
			
//			LCD.drawString(Float.toString(hsb[0]) + " " + Float.toString(hsb[1]) + " " + Float.toString(hsb[2]), 0, 0);
//			LCD.drawString(Float.toString(rgb[0]) + " " + Float.toString(rgb[1]) + " " + Float.toString(rgb[2]), 0, 0);
		}
	}
	
}
