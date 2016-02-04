package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

	// Creating the right and left TALON SRX using CAN
	private CANTalon rightShoulder, leftShoulder;
	public double sensorPosition;
	private final double p = 0.01;
	private final double i = 0.0;
	private final double d = 0.0;
	private double ticks;
	private double degrees;
	private static double shoulderAngle;
	private double stickPosition;
	private double EncoderTicks;
	private double setpoint;

	public Shoulder() {
		rightShoulder = new CANTalon(RobotMap.rightShoulderID); // See RobotMap
																// for IDs
		leftShoulder = new CANTalon(RobotMap.leftShoulderID);
		rightShoulder.setPosition(0);
		rightShoulder.reverseSensor(false);
		rightShoulder.enableLimitSwitch(false, true); // Shoulder Limit switch
														// to prevent driving
														// arms into floor

		rightShoulder.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative); // Using
																					// a
																					// Quadrature
																					// Encoder

		leftShoulder.changeControlMode(TalonControlMode.Follower);
		leftShoulder.set(rightShoulder.getDeviceID());

		leftShoulder.enableBrakeMode(true);
		rightShoulder.enableBrakeMode(true);
		rightShoulder.setP(this.p);
		rightShoulder.setI(this.i);
		rightShoulder.setD(this.d);

	}

	public void initDefaultCommand() {
		rightShoulder.changeControlMode(TalonControlMode.PercentVbus); // for
																		// now,
																		// use
																		// manual
	}

	public void manualMode(double pos) {

		// gets manualMode Joystick position

		rightShoulder.changeControlMode(TalonControlMode.PercentVbus); // Position
																		// Based
		stickPosition = pos; //* 0.66; // scales value by 2/3 to prevent smashing
		SmartDashboard.putNumber("StickPosition", stickPosition);
		rightShoulder.set(stickPosition);
	}

	public void modeSwitch(boolean toggle) {
		if (toggle) {
			rightShoulder.changeControlMode(TalonControlMode.Position);
		} else {
			rightShoulder.changeControlMode(TalonControlMode.PercentVbus);
		}

	}

	private double degreesToTicks(double degrees) {

		ticks = degrees * (4096 / 360); // For CTR - Mag Encoder
		return ticks;
	}

	private double ticksToDegrees(double ticks) {
		degrees = ticks * (360 / 4096);
		return degrees;
	}

	public void raiseArm() {

	}

	public double getShoulderPos() {
		ticks = rightShoulder.getPosition();
		shoulderAngle = ticksToDegrees(ticks);

		return shoulderAngle;
	}

	public int getEncoderTicks() {
		return rightShoulder.getEncPosition();
	}

	public double getMotorSetpoint() {
		this.setpoint = ticksToDegrees(rightShoulder.getSetpoint());
		return setpoint;

	}

	public void motorSetpoint(double angle) {
		setpoint = degreesToTicks(angle);
		rightShoulder.set(setpoint);

	}
	
	public void stop(){
		rightShoulder.set(0);
	}
}
