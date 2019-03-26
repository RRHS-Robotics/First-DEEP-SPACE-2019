package org.usfirst.frc.team7043.robot.commands;

import org.usfirst.frc.team7043.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;


public class DriveCommand extends Command {
	
	private boolean invert = false;
	private boolean t = false;
	
	Preferences prefs = Preferences.getInstance();
    
    //TeleMode Constructor
    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.DriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if(Robot.refOI.invertMotorButton()) { invert = !invert; } 
		if(Robot.refOI.invertTweakButton()) { t = !t; } 
		
		Robot.DriveTrain.drive( 
			(invert?-1:1) * -Robot.refOI.controller.getY(Hand.kLeft)*prefs.getDouble("Percent of Max Speed (0.0 to 1.0)", (t?1:.5)), 
			-Robot.refOI.controller.getX(Hand.kLeft)*prefs.getDouble("Percent of Max Speed (0.0 to 1.0)", .5));//(t?1:.5)));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.DriveTrain.stop(); // stop robot
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		Robot.DriveTrain.stop();
    }
}