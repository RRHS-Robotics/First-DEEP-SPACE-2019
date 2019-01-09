/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7043.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static Timer masterTimer = new Timer();
	
	//START Drive Motor Map
	/*public static WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(0); //Talon SRX ID (Set in web config)
	public static WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(1); //Talon SRX ID (Set in web config)
	public static WPI_TalonSRX rearRightMotor = new WPI_TalonSRX(2); //Talon SRX ID (Set in web config)
	public static WPI_TalonSRX rearLeftMotor = new WPI_TalonSRX(3); //Talon SRX ID (Set in web config)*/
	
	public static SpeedControllerGroup leftDrive = new SpeedControllerGroup(null, null);//frontLeftMotor, rearLeftMotor);
	public static SpeedControllerGroup rightDrive = new SpeedControllerGroup(null, null);//frontRightMotor, rearRightMotor);
	
	public static DifferentialDrive robotDriveMain; // = new DifferentialDrive(RobotMap.leftDrive, RobotMap.rightDrive);
	//END Drive Motor Map
	
}
