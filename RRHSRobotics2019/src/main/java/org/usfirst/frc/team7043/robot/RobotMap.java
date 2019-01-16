/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7043.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
	
	//START Drive Motor Map
	public static Talon frontLeftMotor = new Talon(0); //Talon  ID (Set in web config)
	public static Talon frontRightMotor = new Talon(1); //Talon  ID (Set in web config)
	public static Talon rearRightMotor = new Talon(2); //Talon  ID (Set in web config)
	public static Talon rearLeftMotor = new Talon(3); //Talon  ID (Set in web config)
	
	public static SpeedControllerGroup leftDrive = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
	public static SpeedControllerGroup rightDrive = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
	
	public static DifferentialDrive robotDriveMain; // = new DifferentialDrive(RobotMap.leftDrive, RobotMap.rightDrive);
	//END Drive Motor Map
	
}
