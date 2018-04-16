import java.io.IOException;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class Main {
	static final int PORT = 6666;
	static String currentCommand;

	static IRSensorThread irThread;
	static ColorSensorThread colorThread;
	static LeftUltrasonicSensorThread leftUltrasonicThread;
	static RightUltrasonicSensorThread rightUltrasonicThread;
	static SocketServerThread socketServerThread;


	public static void main(String[] args) throws IOException {
		irThread = new IRSensorThread();
		colorThread = new ColorSensorThread();
		leftUltrasonicThread = new LeftUltrasonicSensorThread();
		rightUltrasonicThread = new RightUltrasonicSensorThread();
		socketServerThread = new SocketServerThread();
		
		socketServerThread.start();
		irThread.start();
		colorThread.start();
		leftUltrasonicThread.start();
		rightUltrasonicThread.start();
		
		LCD.clear();
		LCD.drawString("Server started", 0, 0);

		while(!Button.ESCAPE.isDown()){
			try { Thread.sleep(100); } 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	      
	}

}
