package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.shooter.DeliverScaleAuto;
import org.usfirst.frc.team614.robot.commands.shooter.DeliverScaleOppositeAuto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScaleOpposite extends CommandGroup {

    public LeftScaleOpposite() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.

    	double speed = 0.7;
    	
		addSequential(new DriveForADistance(210, speed));
		addSequential(new RotateToAngle(-90, false));
		addSequential(new DriveForADistance(-190, speed));
		addSequential(new RotateToAngle(-95, false));
		addParallel(new DriveForADistance(-20, speed));
		addSequential(new DeliverScaleAuto());
    }
}
