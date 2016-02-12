package org.usfirst.frc.team1250.formulas;


public class Convert {
	
	private static double heightTotal;
	private static double angleArm;
	private static double angleWheel;
	private static final double THETA_K = 22.2473;
	private static final double HEIGHT_PIVOT = 15;
	private static final double LENGTH_WHEELPIVOT = 43.189; 
	
	
	private static double ArmToWheel(double armAngle){
		return armAngle - THETA_K; // Constant angle between pivot point and wheel
	}
	private static double WheelToArm(double wheelAngle){
		
		return wheelAngle + THETA_K;
	}
	
	// Takes in arm Angle as a degree and converts to wheel Height
	public static double ArmToWheelHeight(double armAngle){
		// Converts input from Degrees to Radians
		angleWheel = Degree2Rad(ArmToWheel(armAngle));
		//angleWheel = Degree2Rad(angleWheel);
		heightTotal = HEIGHT_PIVOT + LENGTH_WHEELPIVOT*Math.sin(angleWheel);
		return heightTotal;
	}
	
	public static double WheelToArmAngle(double heightTotal){
		
		// Converts Output from Radians to Degrees
		angleWheel =  Rad2Degree(1/Math.sin((heightTotal-HEIGHT_PIVOT)/LENGTH_WHEELPIVOT));
	
//		angleWheel = Rad2Degree(angleWheel);
		angleArm = WheelToArm(angleWheel);
		return angleArm;
	}
	
	private static double Rad2Degree(double Rad){
		return  (180/Math.PI)*Rad;

	}
	
	private static double Degree2Rad(double degree){
		return  (Math.PI/180)*degree;

	}
}
