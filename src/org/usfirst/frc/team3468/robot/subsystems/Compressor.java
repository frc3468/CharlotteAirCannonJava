package org.usfirst.frc.team3468.robot.subsystems;

import org.usfirst.frc.team3468.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Compressor extends Subsystem {
	Jaguar compressor = new Jaguar(RobotMap.compressorPWM);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void on() {
    	compressor.set(1.0);
    }
    
    public void off() {
    	compressor.set(0.0);
    }
}

