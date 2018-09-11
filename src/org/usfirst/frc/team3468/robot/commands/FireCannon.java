package org.usfirst.frc.team3468.robot.commands;

import org.usfirst.frc.team3468.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FireCannon extends Command {
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	
	int cannon;
	
    public FireCannon(int cannonNumber) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.turret);
    	setTimeout(0.2);
    	cannon = cannonNumber;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(cannon == FireCannon.LEFT) {
    		Robot.turret.setLeftCannon(true);
    	}
    	if(cannon == FireCannon.RIGHT) {
    		Robot.turret.setRightCannon(true);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.turret.setLeftCannon(false);
    	Robot.turret.setRightCannon(false);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
