package team.gif.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.RobotMap;
import team.gif.commands.collector.CollectorAngleNeutral;

/**
 *
 */
public class CollectorAngle extends Subsystem {
    
	public static final CANTalon collectorAngleOne = new CANTalon(RobotMap.collectorAngleOne);
	public static final CANTalon collectorAngleTwo = new CANTalon(RobotMap.collectorAngleTwo);
	private double height;
	
	public CollectorAngle() {
		super();
	}
	
	public void angle(double speed) {
		collectorAngleOne.set(speed);
		collectorAngleTwo.set(speed);
		height += speed * 0.02;
    	SmartDashboard.putNumber("Collector Height", height);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new CollectorAngleNeutral());
    }
}

