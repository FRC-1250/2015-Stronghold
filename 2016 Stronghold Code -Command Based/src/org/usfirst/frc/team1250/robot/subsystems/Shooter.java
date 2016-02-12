package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.commands.DriveWithJoystick;

import com.ni.vision.NIVision.GeometricSetupDataItem;

import org.usfirst.frc.team1250.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
/**
 *
 */
public class Shooter extends Subsystem {
    
	private CANTalon leftShooterMotor, rightShooterMotor;
	public Servo shooterServo;
	private DigitalInput lightSensor;
	public final static double STOP = 0;
	public final static double FORWARD = 1;
	public final static double REVERSE = -1;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	public Shooter(){
		shooterServo = new Servo(RobotMap.shooterServoID);
		leftShooterMotor = new CANTalon(RobotMap.leftShooterMotorID);
		rightShooterMotor = new CANTalon(RobotMap.rightShooterMotorID);
		
		lightSensor = new DigitalInput(RobotMap.lightSensorID);
		leftShooterMotor.setInverted(false);
		leftShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
		
		rightShooterMotor.changeControlMode(TalonControlMode.Follower);
		rightShooterMotor.set(rightShooterMotor.getDeviceID());
		rightShooterMotor.reverseSensor(true);
		
	}
	
	public void servoUp(){
		shooterServo.set(0);
	}
	
	public void servoDown(){
		shooterServo.set(1);	
	}
	
	public void servoPosition(double input){
		shooterServo.set(input);
	}
	
	public double getServoPos(){
		return shooterServo.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	shooterServo.set(0.5);
    }
    
    public void motorSpeed(double throttleValue){
    	leftShooterMotor.set(throttleValue);
    }
    
    public boolean hasBall(){
    	return !lightSensor.get();
    }
}

