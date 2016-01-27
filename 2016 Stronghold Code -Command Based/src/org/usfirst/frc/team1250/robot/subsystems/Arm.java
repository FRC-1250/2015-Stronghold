package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team1250.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import org.usfirst.frc.team1250.robot.RobotMap;

/**
 * The Arm Subsystem has two TalonSRX motor and a detector
 * to check if ball is inside the arms to open or close the arm
 * Also will either collect or shoot the ball depending on loading
 */
public class Arm extends Subsystem {
	
	// Constants for speeds
	public static final double FORWARD = 1;
	public static final double STOP = 0;
	public static final double REVERSE = -1;
	
	// Devices
	private CANTalon rightArm;
	private CANTalon leftArm;
	private DigitalInput armDIO;
	private Servo pivot;
	
	public Arm(){
		
		armDIO = new DigitalInput(RobotMap.armDIO);
		
		rightArm = new CANTalon(RobotMap.rightArm);
		leftArm = new CANTalon(RobotMap.leftArm);
		
		rightArm.changeControlMode(TalonControlMode.PercentVbus);
		leftArm.changeControlMode(TalonControlMode.Follower);
		leftArm.set(rightArm.getDeviceID());
		leftArm.reverseOutput(true); // Reversing slave motor output
			
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean hasBall(){
    	return armDIO.get();
    }
    
    public void setSpeed(double speed){
    	rightArm.set(speed);
    }
}

