package org.usfirst.frc.team614.robot.commands.intake;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToggleLoaderPiston extends Command {

	public ToggleLoaderPiston() {
		requires(Robot.pneumatics);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.pneumatics.getLoaderState().equals(RobotMap.PistonOut)) {
			Robot.pneumatics.setLoaderState(RobotMap.PistonIn);
		} else {
			Robot.pneumatics.setLoaderState(RobotMap.PistonOut);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this .  true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
