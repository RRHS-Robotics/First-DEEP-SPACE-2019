/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7043.robot;

import org.usfirst.frc.team7043.robot.commands.DriveCommand;
import org.usfirst.frc.team7043.robot.subsystems.DriveTrainSubsystem;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveTrainSubsystem DriveTrain = new DriveTrainSubsystem();
  public static OI refOI;
  public static RobotMap robotMap = new RobotMap();
  
  public Boolean DEBUG;

  public Preferences prefs;
  
  public UsbCamera primaryCamera;
  public UsbCamera secondaryCamera;
  public VideoSink cameraServer;
  public CvSink cvsink1;
  public CvSink cvsink2;
  
  Command driveTrainCommand = new DriveCommand();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    refOI = new OI();
    
    primaryCamera = CameraServer.getInstance().startAutomaticCapture(0);
    secondaryCamera = CameraServer.getInstance().startAutomaticCapture(1);
	cameraServer = CameraServer.getInstance().getServer();
	cvsink1 = new CvSink("PrimaryCameraCV");
	cvsink1.setSource(primaryCamera);
	cvsink1.setEnabled(true);
	cvsink2 = new CvSink("SecondaryCameraCV");
	cvsink2.setSource(secondaryCamera);
	cvsink2.setEnabled(true);
    
    RobotMap.leftDrive.setInverted(true);
	RobotMap.robotDriveMain = new DifferentialDrive(RobotMap.leftDrive, RobotMap.rightDrive);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard.
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above or additional comparisons
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
	  setCamera(primaryCamera);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
	if (refOI.primaryCameraButton() && !refOI.secondaryCameraButton()) {
		setCamera(primaryCamera);
	} else if (refOI.secondaryCameraButton() && !refOI.primaryCameraButton()){
		
	}
    Scheduler.getInstance().run();
  }
  
  //Sets Camera
  public void setCamera(UsbCamera cam) {
	  String ext = "Unknown";
	  if (cam==primaryCamera) {
		  ext = "Primary";
	  }
	  SmartDashboard.putString("Info", "Setting "+ext+" Camera");
	  cameraServer.setSource(cam);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {}
}
