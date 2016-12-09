package team.gif.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.TankDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    public static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
    public static final CANTalon frontRight = new CANTalon(RobotMap.frontRight);
    public static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeft);
    public static final CANTalon rearRight = new CANTalon(RobotMap.rearRight);
    public static final Encoder leftEncoder = new Encoder(RobotMap.leftEncoderOne, RobotMap.leftEncoderTwo);
    public static final Encoder rightEncoder = new Encoder(RobotMap.rightEncoderOne, RobotMap.rightEncoderTwo);
    
    public Drivetrain() {
    	super();
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public void drive(double left, double right) {
    	frontLeft.set(left);
    	rearLeft.set(left);
    	frontRight.set(right);
    	rearRight.set(right);
    }
    
    public double getLeftEncoder() {
    	return leftEncoder.get();
    }
    
    public double getRightEncoder() {
    	return -rightEncoder.get();
    }
    
    public void driveForTicks(double ticks) {
		drive(1.0 - (getRightEncoder() / ticks), 1.0 - (getRightEncoder() / ticks));
    }
    
    public void pDrive(double setpoint) {
    	drive(Globals.kP * (setpoint - getRightEncoder()), Globals.kP * (setpoint - getRightEncoder()));
    }
    
    public void pRotate(double setpoint) {
    	drive(-Globals.kPRotate * (setpoint - getRightEncoder()), Globals.kPRotate * (setpoint - getRightEncoder()));
    }
    
    public void bangBang(double setpoint, double range) {
    	if(getRightEncoder() < setpoint-range)
    		drive(0.5,0.5);
    	if(getRightEncoder() > setpoint+range)
    		drive(-0.5,-0.5);
    	if(getRightEncoder() < setpoint+range && getRightEncoder() > setpoint-range)
    		drive(0,0);
    }
    
    
/*    public void gyroDrive(double ticks) {
    	double driveSpeed = 1.0 - (getRightEncoder() / ticks);
    	double rotateSpeed = gyro.getAngle() * 0.01;
    	drive(Math.min(1, driveSpeed - rotateSpeed), Math.min(1, driveSpeed + rotateSpeed));
    }*/
    
    public void resetEncoders() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
}

