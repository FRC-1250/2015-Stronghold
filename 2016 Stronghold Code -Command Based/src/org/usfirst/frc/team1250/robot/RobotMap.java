package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	
	public static int leftStick = 0;
	public static int rightStick = 1;
	public static int frntRightMotorID = 12;
	//public static int midRightMotorID = 12;
	public static int bckRightMotorID = 11;
	
	public static int frntLeftMotorID = 15;
	//public static int midLeftMotorID = 15;
	public static int bckLeftMotorID = 16;
	
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}