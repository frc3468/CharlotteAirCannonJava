package org.usfirst.frc.team3468.robot.subsystems;

import org.usfirst.frc.team3468.robot.RobotMap;
import org.usfirst.frc.team3468.robot.commands.TurretLift;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Turret extends Subsystem {
	Talon leftCannon = new Talon(RobotMap.leftCannonPWM);
	Talon rightCannon = new Talon(RobotMap.rightCannonPWM);
	
	Talon cannonLift = new Talon(RobotMap.cannonLiftMotor);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TurretLift());
    }
    
    public void turretLift(double speed) {
    	cannonLift.set(speed);
    	
    }
    
    public void setLeftCannon(boolean state) {
    	if(state == true) {
    		leftCannon.set(1.0);
    	} else {
    		leftCannon.set(0.0);
    	}
    }
    
    public void setRightCannon(boolean state) {
    	if(state == true) {
    		rightCannon.set(1.0);
    	} else {
    		rightCannon.set(0.0);
    	}
    }
}

