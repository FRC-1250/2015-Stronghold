package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1250.robot.subsystems.DriveTrain;

/**
 *
 */
public class DriveWithJoystick extends Command {

	private double rightStick;
	private double leftStick;
	private int rightOutput, leftOutput;
	private double setpoint;
    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.drivetrain.tankDrive(Robot.oi.getLeftStick(),Robot.oi.getRightStick(),true);
    	
    	leftStick = Robot.oi.getLeftStick();
    	rightStick = Robot.oi.getRightStick();
    	Robot.drivetrain.tankDrive(rightStick, leftStick, true);
    	
    	if (leftStick> 0){
    		leftOutput = 1;
    	}else if(leftStick<0){
    		leftOutput = -1;
    	}
    	
    	if (rightStick > 0) {
    		rightOutput = 1;
    	}else if (rightStick< 0){
    		rightOutput=-1;
    	}
    	
    	if (rightOutput == leftOutput){
    		
    		if (rightOutput>0){
    			setpoint = Math.min(leftStick, rightStick);
    			Robot.collector.setSpeed(setpoint);	
    		}else if (rightOutput<0){
    			setpoint = Math.max(leftStick, rightStick);
    			Robot.collector.setSpeed(setpoint);
    		}
    		
    	}else{
    		Robot.collector.setSpeed(0);
    	}

    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
