package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.drivetrain.TankDrive;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DrivetrainCompanion extends Subsystem implements PIDOutput {
	PIDController distanceController;

	private double PIDdistanceSpeed;

	private boolean usingDistancePID;

	/* The following PID Controller coefficients will need to be tuned */
	/* to match the dynamics of your drive system. Note that the */
	/* SmartDashboard in Test mode has support for helping you tune */
	/* controllers by displaying a form where you can enter new P, I, */
	/* and D constants and test the mechanism. */

    public final double distanceTolerance = 0.1f;
    public double last_world_linear_accel_x;
    public double last_world_linear_accel_y;
    public double last_world_linear_accel_z;
    public double currentJerkX;
    public double currentJerkY;
    public double currentJerkZ;

	// VictorSP motor controllers
	// VictorSP leftMotor = new VictorSP(RobotMap.drivetrainLeftMotor);
	// VictorSP rightMotor = new VictorSP(RobotMap.drivetrainRightMotor);

	public DrivetrainCompanion() {

		usingDistancePID = false;

		distanceController = new PIDController(RobotMap.drivetrainDistanceP,
				RobotMap.drivetrainDistanceI, RobotMap.drivetrainDistanceD,
				RobotMap.drivetrainDistanceF, Robot.drivetrain.leftEncoder,
				this);
		distanceController.setOutputRange(-1.0, 1.0);
		distanceController.setAbsoluteTolerance(distanceTolerance);

		/* Add the PID Controller to the Test-mode dashboard, allowing manual */
		/* tuning of the Turn Controller's P, I and D coefficients. */
		/* Typically, only the P value needs to be modified. */
		LiveWindow.addActuator("DriveSystem", "DistanceController",
				distanceController);

	}
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	 //setDefaultCommand(new CollisionDetected());
    }

	
	public void runCollisionDetection() {
		double curr_world_linear_accel_x = Robot.navX.getWorldLinearAccelX();
        currentJerkX = curr_world_linear_accel_x - last_world_linear_accel_x;
        last_world_linear_accel_x = curr_world_linear_accel_x;
        double curr_world_linear_accel_y = Robot.navX.getWorldLinearAccelY();
        currentJerkY = curr_world_linear_accel_y - last_world_linear_accel_y;
        last_world_linear_accel_y = curr_world_linear_accel_y;
        double curr_world_linear_accel_z = Robot.navX.getWorldLinearAccelZ();
        currentJerkZ = curr_world_linear_accel_z - last_world_linear_accel_z;
        last_world_linear_accel_z = curr_world_linear_accel_z;
	}

	public void setUsingDistancePID(boolean set) {
		usingDistancePID = true;
		if (usingDistancePID) {
			distanceController.enable();
		} else {
			distanceController.disable();
		}
	}

	public boolean getUsingDistancePID() {
		return usingDistancePID;
	}

	public double getPIDSpeed() {
		return PIDdistanceSpeed; //Returns Output
	}

	public PIDController getDistanceController() {
		return distanceController;
	}

	public void pidWrite(double output) {
		if (usingDistancePID) {
			PIDdistanceSpeed = output;
		}
	}	
}
