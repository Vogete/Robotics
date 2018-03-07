import lejos.hardware.*;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;
import lejos.hardware.lcd.LCD;

public class Assignment1 {
	public static void main(String[] args) {
		
		/***** MOTOR *****/
//		runWithMotorController();
		
		/***** MOVEPILOT *****/
		runWithMovePilotController();
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
	
	public static void runWithMovePilotController() {
		 
		Wheel wheel1 = WheeledChassis.modelWheel(Motor.A, 43.2).offset(-64);
		Wheel wheel2 = WheeledChassis.modelWheel(Motor.B, 43.2).offset(64);

		Chassis chassis = new WheeledChassis(new Wheel[]{wheel1, wheel2}, WheeledChassis.TYPE_DIFFERENTIAL);
		MovePilot pilot = new MovePilot(chassis);
		
		pilot.setLinearSpeed(6000);
		
		
		
		pilot.travel(500);
		try { Thread.sleep(500); } catch(Exception e) {}		
		pilot.arc(200, 90);
//		MotorController.turn(200, 90, "right");

		try { Thread.sleep(500); } catch(Exception e) {}
		pilot.travel(300);
		try { Thread.sleep(500); } catch(Exception e) {}
		
//		MotorController.turn(200, 90, "right");
		pilot.arc(200, 90);
		try { Thread.sleep(500); } catch(Exception e) {}
		
		pilot.travel(200);
		try { Thread.sleep(500); } catch(Exception e) {}
		
		pilot.rotate(90);
		try { Thread.sleep(500); } catch(Exception e) {}
		
		pilot.travel(300);
		try { Thread.sleep(500); } catch(Exception e) {}
		
		pilot.rotate(-90);
		try { Thread.sleep(500); } catch(Exception e) {}

		pilot.travel(200);
		try { Thread.sleep(500); } catch(Exception e) {}
		
		pilot.arc(100, 90);
//		MotorController.turn(100, 90, "right");
		
		pilot.travel(300);
		
		pilot.stop();
				

	}

	
}
