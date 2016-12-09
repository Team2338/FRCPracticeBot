package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveThenTurn extends CommandGroup {
    
    public  DriveThenTurn() {
        addSequential(new PDrive());
        addSequential(new PRotate());
    }
}
