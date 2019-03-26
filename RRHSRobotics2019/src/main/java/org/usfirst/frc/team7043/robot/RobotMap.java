/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7043.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
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
	public static WPI_VictorSPX frontLeftMotor = new WPI_VictorSPX(0); //Victor SPX ID (Set in web config)
	public static WPI_VictorSPX frontRightMotor = new WPI_VictorSPX(1); //Victor SPX ID (Set in web config)
	public static WPI_VictorSPX rearRightMotor = new WPI_VictorSPX(2); //Victor SPX ID (Set in web config)
	public static WPI_VictorSPX rearLeftMotor = new WPI_VictorSPX(3); //Victor SPX ID (Set in web config)
	
	public static SpeedControllerGroup leftDrive = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
	public static SpeedControllerGroup rightDrive = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
	
	public static DifferentialDrive robotDriveMain; // = new DifferentialDrive(RobotMap.leftDrive, RobotMap.rightDrive);
	//END Drive Motor Map
	
	//Start Solenoid Map
	public static Solenoid pn = new Solenoid(6, 1);
	//End Solenoid Map
	
	//Start Pulley System Map
	public static Spark pulleyMotor = new Spark(0); //PWM Pin group 2 on RoboRio
	//End Pulley System Map
	
	//START Ball Motor Map
	public static Spark ballMotor = new Spark(1);
	//END Ball Motor Map
	
	
	
}
