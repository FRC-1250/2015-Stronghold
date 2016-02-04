package org.usfirst.frc.team1250.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.OI;

/** Commands the Collector to either Collect or Eject
 *
 */
public class CollectorSpeed extends Command {
	
	private double speed;
	private static boolean isReleased = false;
	
    public CollectorSpeed(double speed) {
        requires(Robot.collector);
        this.speed = speed;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collector.setSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
