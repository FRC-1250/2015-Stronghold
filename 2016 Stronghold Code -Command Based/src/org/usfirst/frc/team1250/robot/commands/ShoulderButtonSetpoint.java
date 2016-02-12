package org.usfirst.frc.team1250.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1250.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class ShoulderButtonSetpoint extends Command {

	private double angle;
	
    public ShoulderButtonSetpoint() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shoulder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	angle = SmartDashboard.getNumber("Shoulder Setpoint Angle");
    	Robot.shoulder.motorSetpoint(angle);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
