package org.usfirst.frc.team1250.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.OI;
import edu.wpi.first.wpilibj.buttons.*;

/** Commands the Collector to either Collect or Eject
 *
 */
public class CollectorSpeed extends Command {
	
	private double speed;
	private double zValue;
	
    public CollectorSpeed() {
        requires(Robot.collector);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	zValue = Robot.oi.manualStick.getZ();
    	if (zValue> 0.5){
    		speed = -1;
    	}else if (zValue <0.5){
    		speed = 1;
    	}

    	Robot.collector.setSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	zValue = Robot.oi.manualStick.getZ();
    	if (zValue> 0.5){
    		speed = 1;
    	}else if (zValue <0.5){
    		speed = -1;
    	}

    	Robot.collector.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return Robot.oi.getCollectorButton();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.stop();;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
