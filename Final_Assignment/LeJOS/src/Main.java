import java.io.IOException;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.subsumption.Arbitrator;

public class Main {
	static final int PORT = 6666;
	static volatile String currentCommand;

	//???
	static volatile String previousMovementCommand;

	static ArbitratorThread arbThread;
	static IRSensorThread irThread;
	static ColorSensorThread colorThread;
	static LeftUltrasonicSensorThread leftUltrasonicThread;
	static RightUltrasonicSensorThread rightUltrasonicThread;
	static SocketServerThread socketServerThread;
	static MotorSpeedThread motorSpeedThread;
	
	public volatile static String clientCommand = "";
	public volatile static float irDistance;
	public volatile static float rightUltrasonicDistance;
	public volatile static float leftUltrasonicDistance;
	
	public volatile static int leftMotorCurrentSpeed;
	public volatile static int rightMotorCurrentSpeed;
	public volatile static String movementDirection;

	public static void main(String[] args) throws IOException {
		movementDirection = "S";
		leftMotorCurrentSpeed = 0;
		rightMotorCurrentSpeed = 0;
		
		motorSpeedThread = new MotorSpeedThread();
		irThread = new IRSensorThread();
		colorThread = new ColorSensorThread();
		leftUltrasonicThread = new LeftUltrasonicSensorThread();
		rightUltrasonicThread = new RightUltrasonicSensorThread();		
		
		motorSpeedThread.start();
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
