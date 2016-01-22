package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1250.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;;


/**
 *
 */
public class Shoulder extends Subsystem {
	
	private CANTalon rightShoulder, leftShoulder;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Shoulder(){
		rightShoulder = new CANTalon(RobotMap.rightShoulderID);
		leftShoulder = new CANTalon(RobotMap.leftShoulderID);
		
		rightShoulder.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		
		
		rightShoulder.changeControlMode(TalonControlMode.Position);
		
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

