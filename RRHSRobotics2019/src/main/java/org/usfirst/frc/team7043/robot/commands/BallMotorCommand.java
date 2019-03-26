package org.usfirst.frc.team7043.robot.commands;

import org.usfirst.frc.team7043.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallMotorCommand extends Command {
	
	Preferences prefs = Preferences.getInstance();
	
	float a = 1.0f;
	
    //TeleMode Constructor
    public BallMotorCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.BallMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.BallMotor.setSpeed((Robot.refOI.ballUpMotorButton()?a:0)+(Robot.refOI.ballDownMotorButton()?-.2:0));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.BallMotor.stop(); // stop robot
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		Robot.BallMotor.stop();
    }
}
