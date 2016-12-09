package team.gif.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class IntakeManualUp extends Command {

    public IntakeManualUp() {
        requires(Robot.collectorAngle);
        requires(Robot.dart);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.collectorAngle.angle(Globals.collectorAngleSpeed);
    	Robot.dart.angle(Globals.dartSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
