import lejos.hardware.*;
import lejos.utility.Delay;

public class Assignment1 {
	public static void main(String[] args) {
		//MotorController.logMessage("Hello");
		MotorController.moveForward(500, 6000);
		//try { Thread.sleep(1000); } catch(Exception e) {}
		MotorController.turn(200, 90, "right");
		MotorController.moveForward(300, 6000);
		MotorController.turn(200, 90, "right");
	}
}
