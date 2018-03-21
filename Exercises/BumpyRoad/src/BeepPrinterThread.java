import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;

public class BeepPrinterThread extends Thread {
	public BeepPrinterThread() {
		this.setDaemon(true);
	}
	
	public void run() {
		while(true) {
			LCD.clearDisplay();
		    LCD.drawString("Number of beeps: " + Main.beepCounter, 0, 0);
			try { Thread.sleep(100); } 
			catch (InterruptedException e) { e.printStackTrace();}
		}
	}
}
