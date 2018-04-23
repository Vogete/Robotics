import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class ArbitratorThread extends Thread {

	Arbitrator arb;
	
	public ArbitratorThread() {
		Behavior manualControlBehavior = new ManualControlBehavior();
		Behavior avoidObjectBehavior = new AvoidObjectsBehavior();
		Behavior emergencyStopBehavior = new EmergencyStopBehavior();
		Behavior lineFollowBehavior = new LineFollowBehavior();
		
		Behavior[] behaviors = {manualControlBehavior, lineFollowBehavior, avoidObjectBehavior, emergencyStopBehavior};
		arb = new Arbitrator(behaviors);
		this.setDaemon(true);
	}
	
	  public void run() {
		  while(true){
			  arb.go();
		  }
	  }
}
