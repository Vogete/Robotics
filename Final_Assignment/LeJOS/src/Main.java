import java.io.IOException;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.subsumption.Arbitrator;

public class Main {
	static final int PORT = 6666;
	static String currentCommand;

	static ArbitratorThread arbThread;
	static IRSensorThread irThread;
	static ColorSensorThread colorThread;
	static LeftUltrasonicSensorThread leftUltrasonicThread;
	static RightUltrasonicSensorThread rightUltrasonicThread;
	static SocketServerThread socketServerThread;
	
	public volatile static String clientCommand = "";
	public volatile static float irDistance;
	public volatile static float rightUltrasonicDistance;
	public volatile static float leftUltrasonicDistance;


	public static void main(String[] args) throws IOException {
		irThread = new IRSensorThread();
		colorThread = new ColorSensorThread();
		leftUltrasonicThread = new LeftUltrasonicSensorThread();
		rightUltrasonicThread = new RightUltrasonicSensorThread();
		
		irThread.start();
		colorThread.start();
		leftUltrasonicThread.start();
		rightUltrasonicThread.start();
		
		arbThread = new ArbitratorThread();
		arbThread.start();
		
		socketServerThread = new SocketServerThread();
		socketServerThread.start();
		
		
		//will not get here, put on separate thread
		while(!Button.ESCAPE.isDown()){
			try { Thread.sleep(100); } 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	      
	}

}
