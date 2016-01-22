package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.buttons.Button;
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
	// public Joystick leftJoystick;
	//public Joystick rightJoystick;

	public OI(){
		gamepad = new Joystick(RobotMap.gamepad);
		// leftJoystick = new Joystick(RobotMap.leftStick);
		// rightJoystick = new Joystick(RobotMap.rightStick);
		
		
	
	}
	public double getLeftStick(){
		return gamepad.getY();
	}
	
	public double getRightStick(){
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

