package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class PDrive extends Command {

	public double setpoint = 2000;
	
    public PDrive() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoders();

//    	setTimeout(4);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.pDrive(setpoint);
    	

//    	SmartDashboard.putBoolean("IsTimedOut", isTimedOut());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return isTimedOut();
    	return Math.abs(setpoint - Robot.drivetrain.getRightEncoder()) < Globals.PDriveRange;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
