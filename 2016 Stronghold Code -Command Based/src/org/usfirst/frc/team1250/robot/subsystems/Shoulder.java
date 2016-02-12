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
	public static double p = 2.0;
	public static double i = 0.0;
	public static double d = 0.0;
	public static double manualAngleSetpoint;
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
		leftShoulder.setPosition(0);
		leftShoulder.reverseSensor(false);
		//leftShoulder.reverseOutput(true);
		leftShoulder.enableLimitSwitch(false, true); // Shoulder Limit switch
														// to prevent driving
														// arms into floor

		leftShoulder.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative); 
		
		rightShoulder.changeControlMode(TalonControlMode.Follower);
		rightShoulder.set(leftShoulder.getDeviceID());
		rightShoulder.reverseOutput(true);
		
		leftShoulder.enableBrakeMode(true);
		rightShoulder.enableBrakeMode(true);
		
		leftShoulder.setP(this.p);
		leftShoulder.setI(this.i);
		leftShoulder.setD(this.d);
		
		manualAngleSetpoint = 0;

	}

	public void initDefaultCommand() {
		leftShoulder.changeControlMode(TalonControlMode.PercentVbus); // for
																		// now,
																		// use
																		// manual
	}

	public void manualMode(double pos) {

		// gets manualMode Joystick position

		leftShoulder.changeControlMode(TalonControlMode.PercentVbus); // Position
																		// Based
		stickPosition = pos; // * 0.66; // scales value by 2/3 to prevent
								// smashing
		SmartDashboard.putNumber("StickPosition", stickPosition);
		leftShoulder.set(stickPosition);
	}

	public void modeSwitch(boolean toggle) {
		if (toggle) {
			leftShoulder.changeControlMode(TalonControlMode.Position);
		} else {
			leftShoulder.changeControlMode(TalonControlMode.PercentVbus);
		}

	}

	private double degreesToTicks(double degrees) {

		ticks = (degrees / 90.0);
		ticks *= -38500.0; // For CTR - Mag Encoder
		return ticks;
	}

	private double ticksToDegrees(double ticks) {
		degrees = (ticks * - 90.0) / 38500.0;
		return degrees;
	}

	public void raiseArm() {

	}

	public double getShoulderAngle() {

		ticks = leftShoulder.getEncPosition();
		shoulderAngle = ticksToDegrees(ticks);

		return shoulderAngle;
		
		//return (Math.abs(leftShoulder.getEncPosition()) * (90.0/38500.0));
		
		
	}

	public int getEncoderTicks() {
		return leftShoulder.getEncPosition();
	}

	public double getMotorSetpoint() {
		this.setpoint = ticksToDegrees(leftShoulder.getSetpoint());
		return setpoint;
	}
	
	public double getAngleSetpoint(){
		return manualAngleSetpoint;
	}

	public void motorSetpoint(double angle) {
		
		leftShoulder.setP(SmartDashboard.getNumber("Shoulder P")/(1000000.0));
		leftShoulder.setI(SmartDashboard.getNumber("Shoulder I"));
		leftShoulder.setD(SmartDashboard.getNumber("Shoulder D"));

		leftShoulder.changeControlMode(TalonControlMode.Position);
		setpoint = degreesToTicks(angle);
				
				//degreesToTicks(angle);
		leftShoulder.set(setpoint);
	
	}
	

	
	/*public double dashboardSetpoint(){
		
		leftShoulder.changeControlMode(TalonControlMode.Position);
		
		setpoint = SmartDashboard.getNumber("Shoulder Angle Setpoint");
		EncoderTicks = degreesToTicks(setpoint);
		
		leftShoulder.setP(SmartDashboard.getNumber("Shoulder P"));
		leftShoulder.setI(SmartDashboard.getNumber("Shoulder I"));
		leftShoulder.setD(SmartDashboard.getNumber("Shoulder D"));

		
		leftShoulder.set(EncoderTicks);
		
		return setpoint;
	}*/
	

	public void stop() {
		leftShoulder.changeControlMode(TalonControlMode.PercentVbus);
		leftShoulder.set(0);
	}
	
	
	public boolean getForwardLim(){
		return leftShoulder.isFwdLimitSwitchClosed();	
	}
	
	public boolean getReverseLim(){
		return leftShoulder.isRevLimitSwitchClosed();
	}
	
	public void resetEncoder(){
		leftShoulder.setPosition(0);
	}
	
	public double getShoulderError() {
		// TODO Auto-generated method stub
		
		return leftShoulder.getError();
	}
	
	public double whatShoulderSetpoint(){
		
		return leftShoulder.getSetpoint();
	}
	
}
