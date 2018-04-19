import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class ArbitratorThread extends Thread {

	Arbitrator arb;
	
	public ArbitratorThread() {
		Behavior manualControlBehavior = new ManualControlBehavior();
		Behavior avoidObjectBehavior = new AvoidObjectsBehavior();
		Behavior[] behaviors = {manualControlBehavior, avoidObjectBehavior};
		arb = new Arbitrator(behaviors);
		this.setDaemon(true);
	}
	
	  public void run() {
		  while(true){
			  arb.go();
		  }
	  }
}
