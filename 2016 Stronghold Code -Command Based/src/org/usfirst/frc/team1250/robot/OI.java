package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team1250.robot.RobotMap;
import org.usfirst.frc.team1250.robot.commands.CollectorSpeed;
import org.usfirst.frc.team1250.robot.commands.ExampleCommand;
import org.usfirst.frc.team1250.robot.commands.ManualModeShoulder;
import org.usfirst.frc.team1250.robot.subsystems.Collector;
import org.usfirst.frc.team1250.robot.subsystems.Shooter;
import org.usfirst.frc.team1250.robot.commands.ThrottleCheck;
import org.usfirst.frc.team1250.robot.commands.ManualDriving;;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * Button Map for the Logitech G310:
 * RawAxis(0) - Left Stick x-axis
 * RawAxis(1) - Left Stick y-axis
 * RawAxis(2) - Left Bottom Shoulder Trigger 	( -1 - 0 only)
 * RawAxis(3) - Right Bottom Shoulder Trigger 	( 0 - 1 only)
 * RawAxis(4) - Right Stick x-axis
 * RawAxis(5) - Right Stick y-axis
 * 
 */
public class OI {
	
	public Joystick gamepad;
	public Joystick manualStick;

	private double leftTrig;
	//private boolean manualShoulderActive;
	// public Joystick leftJoystick;
	//public Joystick rightJoystick;

	public OI(){
		gamepad = new Joystick(RobotMap.gamepad); // Instantiates instance of Joystick class
		manualStick = new Joystick(RobotMap.manualStick);
		JoystickButton trig = new JoystickButton(manualStick, 1);
		JoystickButton b8 = new JoystickButton(manualStick, 8);
		JoystickButton b9 = new JoystickButton(manualStick, 9);
		JoystickButton b2= new JoystickButton (manualStick, 2);
		//JoystickButton bA = new JoystickButton(gamepad, 1);
		
		
		
		//bA.toggleWhenPressed(new ManualDriving());
		trig.whenPressed(new ThrottleCheck());

		
		// Shooter Arm Speed and Direction 
	
		b8.whenPressed(new CollectorSpeed(Collector.FORWARD));
		b9.whenPressed (new CollectorSpeed(Collector.REVERSE));
	
		b2.whenPressed(new ManualModeShoulder());
		
		
		
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
		return gamepad.getRawAxis(5);
	}
	
	public boolean getCollectorButton(){
		return (!manualStick.getRawButton(8) || manualStick.getRawButton(9));
		
	}
	
	public boolean getManualShoulderButton(){
		return !manualStick.getRawButton(2);
		
	}
	
	/*public Joystick getLeftStick() {
		return leftJoystick;
	}
	
	public Joystick getRightStick(){
		return rightJoystick;
		
	}
		*/
}

