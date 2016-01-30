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
import org.usfirst.frc.team1250.robot.commands.ThrottleCheck;
/**
 *
 */
public class Shooter extends Subsystem {
    
	private CANTalon shooterMotor;
	public final static double STOP = 0;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private double shooterMotorSpeed;
	
	public Shooter(){
		shooterMotor = new CANTalon(RobotMap.shooterMotorID);
		shooterMotor.setInverted(false);
		shooterMotor.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void motorSpeed(double throttleValue){
    	shooterMotor.set(throttleValue);
    }
}

