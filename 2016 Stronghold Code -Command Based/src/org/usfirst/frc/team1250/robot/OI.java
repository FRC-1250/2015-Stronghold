package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team1250.robot.RobotMap;
import org.usfirst.frc.team1250.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick gamepad;
	public Joystick manualStick;
	// public Joystick leftJoystick;
	//public Joystick rightJoystick;

	public OI(){
		gamepad = new Joystick(RobotMap.gamepad); // Instantiates instance of Joystick class
		manualStick = new Joystick(RobotMap.manualStick);
		
		
		new JoystickButton(gamepad,1).whenPressed(null);
		
		
		// leftJoystick = new Joystick(RobotMap.leftStick); //if using two Joysticks for tank drive
		// rightJoystick = new Joystick(RobotMap.rightStick);
		
		//SmartDashboard.putData("Raise Arm");
		
	
	}
	
	
	public double getLeftStick(){
		// Returns data on left gamepad stick
		return gamepad.getY();
	}
	
	public double getRightStick(){
		// Returns data on right gamepad stick
		return gamepad.getRawAxis(3);
	}
	
	/*public Joystick getLeftStick() {
		return leftJoystick;
	}
	
	public Joystick getRightStick(){
		return rightJoystick;
		
	}
		*/
}

