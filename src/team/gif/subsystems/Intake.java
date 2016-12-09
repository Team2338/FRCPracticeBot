package team.gif.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.collector.IntakeNeutral;

/**
 *
 */
public class Intake extends Subsystem {
    
	public static final CANTalon flyWheelOne = new CANTalon(RobotMap.flyWheelOne);
	public static final CANTalon flyWheelTwo = new CANTalon(RobotMap.flyWheelTwo);
	public static final CANTalon collector = new CANTalon(RobotMap.collector);
	public static final CANTalon shooterPolycord = new CANTalon(RobotMap.shooterPolycord);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Intake() {
		super();
	}
	
	public void intake(double speed) {
		collector.set(speed);
		shooterPolycord.set(speed);
	}
	
    public void run(double speed) {
    	flyWheelOne.set(-speed);
    	flyWheelTwo.set(-speed);
    }
    
    public void shoot(double speed) {
    	shooterPolycord.set(speed);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new IntakeNeutral());
    }
}

