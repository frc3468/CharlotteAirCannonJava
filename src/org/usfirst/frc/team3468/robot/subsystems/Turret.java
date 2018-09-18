package org.usfirst.frc.team3468.robot.subsystems;

import org.usfirst.frc.team3468.robot.RobotMap;
import org.usfirst.frc.team3468.robot.commands.LowerTurret;
import org.usfirst.frc.team3468.robot.commands.RaiseTurret;
import org.usfirst.frc.team3468.robot.commands.TurretLift;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Turret extends Subsystem {
	Talon leftCannon = new Talon(RobotMap.leftCannonPWM);
	Talon rightCannon = new Talon(RobotMap.rightCannonPWM);
	
	Button lowerLimit = new Button() {
		DigitalInput limitSwitch = new DigitalInput(RobotMap.lowerLimitSwitch);
		
		@Override
		public boolean get() {
			return limitSwitch.get();
		}
	};
	
	Button upperLimit = new Button() {
		DigitalInput limitSwitch = new DigitalInput(RobotMap.upperLimitSwitch);
		
		@Override
		public boolean get() {
			return limitSwitch.get();
		}
	};
	
	Talon cannonLift = new Talon(RobotMap.cannonLiftMotor);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TurretLift());
    	lowerLimit.whileHeld(new RaiseTurret());
    	upperLimit.whileHeld(new LowerTurret());
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

