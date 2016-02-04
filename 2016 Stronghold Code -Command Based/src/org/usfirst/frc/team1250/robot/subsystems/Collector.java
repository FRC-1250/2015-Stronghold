
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
 *
 */
public class Collector extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	// Constants for speeds
		public static final double FORWARD = 1;
		public static final double STOP = 0;
		public static final double REVERSE = -1;

		// Devices
		private CANTalon rightArm;
		private CANTalon leftArm;
		private DigitalInput armDIO;
		private Servo pivot;

		public Collector() {

			armDIO = new DigitalInput(RobotMap.armDIO);

			rightArm = new CANTalon(RobotMap.rightArm);
			leftArm = new CANTalon(RobotMap.leftArm);
			
			rightArm.enableBrakeMode(false);
			leftArm.enableBrakeMode(false);

			rightArm.changeControlMode(TalonControlMode.PercentVbus);
			leftArm.changeControlMode(TalonControlMode.Follower);
			leftArm.set(rightArm.getDeviceID());
			//leftArm.reverseOutput(true); // Reversing slave motor output

		}

		public void initDefaultCommand() {
			// Set the default command for a subsystem here.
			// setDefaultCommand(new MySpecialCommand());
		}

		public boolean hasBall() {
			return armDIO.get();
		}

		public void setSpeed(double speed) {
			rightArm.set(speed);
		}

		public void stop() {
			rightArm.set(STOP);

		}

		public void forward() {
			rightArm.set(FORWARD);
		}

		public void reverse() {
			rightArm.set(REVERSE);
		}

}

