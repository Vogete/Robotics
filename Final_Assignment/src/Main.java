import lejos.hardware.Button;

public class Main {

	public static void main(String[] args) {
		  IRSensorThread irThread = new IRSensorThread();
		  ColorSensorThread colorThread = new ColorSensorThread();
		  LeftUltrasonicSensorThread leftUltrasonicThread = new LeftUltrasonicSensorThread();
		  RightUltrasonicSensorThread rightUltrasonicThread = new RightUltrasonicSensorThread();

		  irThread.start();
		  colorThread.start();
		  leftUltrasonicThread.start();
		  rightUltrasonicThread.start();
		  
	      while(!Button.ESCAPE.isDown()){
	    	  try { Thread.sleep(100);} 
	    	  catch (InterruptedException e) {
				    e.printStackTrace();
	    	  }
	    	  
	      }
	      
	}

}
