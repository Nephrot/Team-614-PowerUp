package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class HighRPMFairlanes extends Command {

    public HighRPMFairlanes() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	setTimeout(SmartDashboard.getNumber("Shooter High Timeout", 0));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.talon1.set(ControlMode.Velocity, 0);
		Robot.shooter.talon2.set(ControlMode.Velocity, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.talon1.set(ControlMode.Velocity, SmartDashboard.getNumber("High Shooter Left Motor Speed", 0.0));
		Robot.shooter.talon2.set(ControlMode.Velocity, SmartDashboard.getNumber("High Shooter Right Motor Speed", 0.0));
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.talon1.set(ControlMode.Velocity, 0);
		Robot.shooter.talon2.set(ControlMode.Velocity, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.talon1.set(ControlMode.Velocity, 0);
		Robot.shooter.talon2.set(ControlMode.Velocity, 0);
    }
}