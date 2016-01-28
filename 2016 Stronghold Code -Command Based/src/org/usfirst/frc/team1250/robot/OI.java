package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team1250.robot.RobotMap;
import org.usfirst.frc.team1250.robot.commands.ArmSpeed;
import org.usfirst.frc.team1250.robot.commands.ExampleCommand;
import org.usfirst.frc.team1250.robot.commands.ManualModeShoulder;
import org.usfirst.frc.team1250.robot.subsystems.Arm;

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
		JoystickButton trig = new JoystickButton(manualStick, 1);
		JoystickButton b2 = new JoystickButton(manualStick, 2);
	JoystickButton b9= new JoystickButton (manualStick, 10);
		trig.whenPressed(new ArmSpeed(Arm.FORWARD));
		trig.whenReleased(new ArmSpeed(Arm.STOP));
		b2.whenPressed (new ArmSpeed(Arm.REVERSE));
		b2.whenReleased(new ArmSpeed(Arm.STOP));
		b9.toggleWhenPressed(new ManualModeShoulder());
		
		
		
//		new JoystickButton(manualStick,1).whileActive(new ArmSpeed(Arm.FORWARD));
//		new JoystickButton(manualStick,2).whileActive(new ArmSpeed(Arm.REVERSE));
		
		// leftJoystick = new Joystick(RobotMap.lefttick); //if using two Joysticks for tank drive
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

