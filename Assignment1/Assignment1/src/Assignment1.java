import lejos.hardware.*;
import lejos.utility.Delay;

public class Assignment1 {
	public static void main(String[] args) {
		
		/***** MOTOR *****/
		runWithMotorController();
		
		/***** MOVEPILOT *****/
	}
	
	public static void runWithMotorController() {
		MotorController.moveForward(500, 6000);
		try { Thread.sleep(500); } catch(Exception e) {}
		MotorController.turn(200, 90, "right");
		try { Thread.sleep(500); } catch(Exception e) {}
		MotorController.moveForward(300, 6000);
		try { Thread.sleep(500); } catch(Exception e) {}
		MotorController.turn(200, 90, "right");
		try { Thread.sleep(500); } catch(Exception e) {}
		MotorController.moveForward(200, 6000);
		try { Thread.sleep(500); } catch(Exception e) {}
		MotorController.rotate(90, 6000);
		try { Thread.sleep(500); } catch(Exception e) {}
		MotorController.moveForward(200, 6000);
		try { Thread.sleep(500); } catch(Exception e) {}
		MotorController.rotate(-90, 6000);
		try { Thread.sleep(500); } catch(Exception e) {}
		MotorController.moveForward(200, 6000);
		try { Thread.sleep(500); } catch(Exception e) {}
		MotorController.turn(100, 90, "right");
		try { Thread.sleep(500); } catch(Exception e) {}
		MotorController.moveForward(300, 6000);
	}
	
}
