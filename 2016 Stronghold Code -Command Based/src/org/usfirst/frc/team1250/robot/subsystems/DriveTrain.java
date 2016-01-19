package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team1250.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;;


/**
 *
 */
public class DriveTrain extends Subsystem {
    
    private CANTalon frntMotorRight, frntMotorLeft;
    //private CANTalon midMotorRight,midMotorLeft;
    private CANTalon bckMotorRight,bckMotorLeft;
    private RobotDrive drive;
    
    public DriveTrain(){
    	// Configuring Motors - make sure Talon's are correctly identified in robot.RobotMap.java
    	frntMotorRight = new CANTalon(RobotMap.frntRightMotorID);
    	//midMotorRight = new CANTalon(RobotMap.midRightMotorID);
    	bckMotorRight = new CANTalon (RobotMap.bckRightMotorID);
    	
    	frntMotorLeft = new CANTalon(RobotMap.frntLeftMotorID);
    	//midMotorLeft = new CANTalon(RobotMap.midLeftMotorID);
    	bckMotorLeft = new CANTalon(RobotMap.bckLeftMotorID);
    	
    	frntMotorLeft.setInverted(false); // Depends on Board Direction
    	frntMotorRight.setInverted(false);
    	
    	// Front Motor Runs through PercentVBus; Mid and Rear follow Front
    	frntMotorRight.changeControlMode(TalonControlMode.PercentVbus);
    	//midMotorRight.changeControlMode(TalonControlMode.Follower);
    	//midMotorRight.set(frntMotorRight.getDeviceID());
    	bckMotorRight.changeControlMode(TalonControlMode.Follower);
    	bckMotorRight.set(frntMotorRight.getDeviceID());
    	
    	frntMotorLeft.changeControlMode(TalonControlMode.PercentVbus);
    	//midMotorLeft.changeControlMode(TalonControlMode.Follower);
    	//midMotorLeft.set(frntMotorLeft.getDeviceID());
    	bckMotorLeft.changeControlMode(TalonControlMode.Follower);
    	bckMotorLeft.set(frntMotorLeft.getDeviceID());
    	
    	
    	drive = new RobotDrive(frntMotorRight,frntMotorLeft);
    	drive.setSafetyEnabled(true);
    	
    	
    	
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());
        
    }
    
    public void tankDrive(Joystick leftStick,Joystick rightStick) {
    	drive.tankDrive(leftStick, rightStick);
    }
    
    public void stop(){
    	drive.tankDrive(0, 0);
    }
}

