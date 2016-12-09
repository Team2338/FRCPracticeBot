package team.gif.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.RobotMap;
import team.gif.commands.shooter.DartNeutral;

/**
 *
 */
public class Dart extends Subsystem {
	
	public static final CANTalon dart = new CANTalon(RobotMap.shooterAngle);
	private double height;
    
    public Dart() {
    	super();
    }
    
    public void angle(double speed) {
    	dart.set(speed);
    	height += speed * 0.02;
    	SmartDashboard.putNumber("Shooter Height", height);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DartNeutral());
    }
}

