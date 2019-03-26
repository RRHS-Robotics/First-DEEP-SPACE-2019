/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7043.robot;

import org.usfirst.frc.team7043.robot.commands.BallMotorCommand;
import org.usfirst.frc.team7043.robot.commands.DriveCommand;
import org.usfirst.frc.team7043.robot.commands.PullyCommand;
import org.usfirst.frc.team7043.robot.subsystems.BallMotorSubsystem;
import org.usfirst.frc.team7043.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team7043.robot.subsystems.PullySubsystem;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final DriveTrainSubsystem DriveTrain = new DriveTrainSubsystem();
	public static final PullySubsystem Pully = new PullySubsystem();
	public static BallMotorSubsystem BallMotor = new BallMotorSubsystem();
	public static OI refOI = new OI();
	public static RobotMap robotMap = new RobotMap();
	
	public Boolean DEBUG;

	public Preferences prefs;
	
	Command driveTrainCommand = new DriveCommand();
	Command ballMotorCommand = new BallMotorCommand();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		prefs = Preferences.getInstance();
		DEBUG = prefs.getBoolean("DEBUG", false);
		
		initCamera("Primary Camera", 0);
		initCamera("Secondary Camera", 1);
		
		RobotMap.leftDrive.setInverted(true);
		RobotMap.robotDriveMain = new DifferentialDrive(RobotMap.leftDrive, RobotMap.rightDrive);
		refOI.raiseIntake.whileHeld(new PullyCommand("raise"));
		refOI.lowerIntake.whileHeld(new PullyCommand("lower"));
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (driveTrainCommand != null) {
			driveTrainCommand.start();
		}
		if (ballMotorCommand != null) {
			ballMotorCommand.start();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		System.out.println(Robot.refOI.controller.getX(Hand.kLeft));
		RobotMap.pn.set(refOI.compressorButton());
	}

	public void initCamera(String name, int ID) {
		UsbCamera cam = CameraServer.getInstance().startAutomaticCapture(ID);
		cam.setFPS(60);
		cam.setResolution(360, 360);
		CameraServer.getInstance().addServer(name, ID).setSource(cam);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {}
}
