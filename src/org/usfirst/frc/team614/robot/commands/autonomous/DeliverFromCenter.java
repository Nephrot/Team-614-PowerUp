package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.shooter.RevShooter;
import org.usfirst.frc.team614.robot.commands.wallCheck.checkAcceleration;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DeliverFromCenter extends CommandGroup {

    public DeliverFromCenter() {
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
    	
    	double speed = 0.8;
    	double distance = Math.sqrt(2) * (11.5 / 5);
    	
    	if (SmartDashboard.getBoolean("L1", false))
    	{
    		addSequential(new RotateToAngle(-45, true));
    		addSequential(new DriveForADistance(distance, speed));
    		addSequential(new RevShooter());
    		
    		if(SmartDashboard.getBoolean("L2",false)) {
    			addSequential(new checkAcceleration());
    			addSequential(new RevShooter());
    		}
    		//else
    			//R2
    	}
    	
    	else if (SmartDashboard.getBoolean("R1", false))
    	{
    		addSequential(new RotateToAngle(45, true));
    		addSequential(new DriveForADistance(distance, speed));
    		addSequential(new RevShooter());
    		
    		if(SmartDashboard.getBoolean("R2",false)) {
    			addSequential(new checkAcceleration());
    			addSequential(new RevShooter());
    		}
    		//else
    			//L2
    	}
    	
    	else
    	{
    		this.addSequential(new DoNothing());
    	}
    }
}
/*Measurements

Switch;

startWallToCloseEdge: 140"
startWallToFarEdge: 196"
edgeWallToCloseEdge: 85.25"
startWallToMiddle: 168"

Scale;

startWallToEdgeOfPlatform: 261.47"
startWallToEdgeOfScale: 299.65"
edgeWallToScale: 71.57"	
*/