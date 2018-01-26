package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.commands.intake.ToggleIntakePiston;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 * If you don't know what this is for than you have probably been here like once
 * or twice
 *
 */
public class DeliverSwitch extends CommandGroup {

	public DeliverSwitch() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.

		addSequential(new ToggleIntakePiston());
		addSequential(new RevShooterSwitch());
		addSequential(new ToggleIntakePiston());
	}

}