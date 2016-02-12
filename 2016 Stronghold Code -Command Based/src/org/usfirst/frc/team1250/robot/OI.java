package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team1250.robot.RobotMap;
import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.commands.Collect;
import org.usfirst.frc.team1250.robot.commands.ShootOut;
import org.usfirst.frc.team1250.robot.commands.ShooterIn;
import org.usfirst.frc.team1250.robot.commands.ExampleCommand;
import org.usfirst.frc.team1250.robot.commands.ManualModeShoulder;
import org.usfirst.frc.team1250.robot.commands.ShoulderButtonSetpoint;
import org.usfirst.frc.team1250.robot.commands.ShoulderButtonStop;
import org.usfirst.frc.team1250.robot.subsystems.Collector;
import org.usfirst.frc.team1250.robot.subsystems.Shooter;
import org.usfirst.frc.team1250.robot.subsystems.Shoulder;


//import org.usfirst.frc.team1250.robot.commands.ManualDriving;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * Button Map for the Logitech G310 (Mode X):
 * RawAxis(0) - Left Stick x-axis
 * RawAxis(1) - Left Stick y-axis
 * RawAxis(2) - Left Bottom Shoulder Trigger 	( -1 - 0 only)
 * RawAxis(3) - Right Bottom Shoulder Trigger 	( 0 - 1 only)
 * RawAxis(4) - Right Stick x-axis
 * RawAxis(5) - Right Stick y-axis
 * Button Map for the Logitech G310 (Mode D):
 * RawAxis(0) - Left Stick x-axis
 * RawAxis(1) - Left Stick y-axis
 * RawAxis(2) - Right Stick x-axis
 * RawAxis(3) - Right Stick y-axis
 */
public class OI {
	
	public Joystick gamepad;
	public Joystick manualStick;
	public Joystick eStopBoard;
/*	public enum Mode{
		DRIVE(6),BAll_COLLECT(7),HI_SHOT(11),LOW_SHOT(10);
		private int value;
		
		private Mode(int value){
			this.value = value;
		}
	}
*/
	private double leftTrig;
	//private boolean manualShoulderActive;
	// public Joystick leftJoystick;
	//public Joystick rightJoystick;

	public OI(){
		gamepad = new Joystick(RobotMap.gamepad); // Instantiates instance of Joystick class
		manualStick = new Joystick(RobotMap.manualStick);
		
		eStopBoard = new Joystick(RobotMap.eStopBoard);
		
		
		JoystickButton trig = new JoystickButton(manualStick, 1);
		JoystickButton g7 = new JoystickButton(gamepad, 7); // gamepad button 7 (D-Mode Only)
		JoystickButton g8 = new JoystickButton(gamepad, 8); // gamepad button 8 (D-Mode Only
		JoystickButton b3= new JoystickButton (manualStick, 3);
		JoystickButton e1 = new JoystickButton(manualStick, 2); // Testing Purposes for Closed Loop
		
		//JoystickButton bA = new JoystickButton(gamepad, 1);
		

		
		//bA.toggleWhenPressed(new ManualDriving());
		trig.whenPressed(new Collect());
		
		
		// Shooter Arm Speed and Direction 
		
		g8.whenPressed(new ShootOut());
		g7.whenPressed(new ShooterIn());

		b3.whenPressed(new ManualModeShoulder());
		
		e1.whenPressed(new ShoulderButtonSetpoint());
		new JoystickButton(manualStick,11).whenReleased(new ShoulderButtonStop());
		
//		new JoystickButton(manualStick,1).whileActive(new ArmSpeed(Arm.FORWARD));
	//	new JoystickButton(manualStick,2).whileActive(new ArmSpeed(Arm.REVERSE));
		
		// leftJoystick = new Joystick(RobotMap.lefttick); //if using two Joysticks for tank drive
		// rightJoystick = new Joystick(RobotMap.rightStick);
		
		//SmartDashboard.putData("Raise Arm");
		
	
	}
	
	
	public double getLeftStick(){
		// Returns data on left gamepad stick
		return gamepad.getRawAxis(1);
	}
	
	public double getRightStick(){
		// Returns data on right gamepad stick
		return gamepad.getRawAxis(3); // use 5 if in X-Mode
	}
	
	public boolean getCollectorButton(){
		return !manualStick.getRawButton(1);
		
	}
	
	public boolean getShooterButton(){
		return !(gamepad.getRawButton(8)||gamepad.getRawButton(7));
		
	}
	
	public boolean getManualShoulderButton(){
		return !manualStick.getRawButton(3);
		
	}
	
	/*public Joystick getLeftStick() {
		return leftJoystick;
	}
	
	public Joystick getRightStick(){
		return rightJoystick;
		
	}
		*/
}

