package org.usfirst.frc.team1250.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
/**
 *
 */
public class ThrottleCheck extends Command {
	
	private double speed;
	private double zValue;
	
    public ThrottleCheck() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	zValue = Robot.oi.manualStick.getZ();
    	
    
    	if (zValue>= 0 && zValue< 0.45){
    		speed = 1;
    	}else if (zValue>= 0.45 && zValue<= 0.55){
    		speed = 0;
    	}else if (zValue>0.55 && zValue <=1){
    		speed = ((-1/0.45)*zValue)+(.55/0.45); 
    	}
    	Robot.shooter.motorSpeed(speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (!Robot.oi.manualStick.getRawButton(1));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.motorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
