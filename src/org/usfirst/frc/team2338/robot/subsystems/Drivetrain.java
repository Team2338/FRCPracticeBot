package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    public static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
    public static final CANTalon frontRight = new CANTalon(RobotMap.frontRight);
    public static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeft);
    public static final CANTalon rearRight = new CANTalon(RobotMap.rearRight);
    
    public Drivetrain() {
    	super();
    }
    
    public void drive(double left, double right) {
    	frontLeft.set(left);
    	rearLeft.set(left);
    	frontRight.set(right);
    	rearRight.set(right);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
}

