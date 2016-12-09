package team.gif;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import team.gif.commands.collector.CollectorManualDown;
import team.gif.commands.collector.CollectorManualUp;
import team.gif.commands.collector.IntakeCollect;
import team.gif.commands.collector.IntakeEject;
import team.gif.commands.collector.IntakeManualDown;
import team.gif.commands.collector.IntakeManualUp;
import team.gif.commands.shooter.DartManualDown;
import team.gif.commands.shooter.DartManualUp;
import team.gif.commands.shooter.Shoot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static final Joystick left = new Joystick(0);
	public static final Joystick right = new Joystick(1);

	Button right1 = new JoystickButton(right, 1);
	Button right2 = new JoystickButton(right, 2);
	Button right3 = new JoystickButton(right, 3);
	Button right4 = new JoystickButton(right, 4);
	Button right5 = new JoystickButton(right, 5);
	Button left2 = new JoystickButton(left, 2);
	Button left3 = new JoystickButton(left, 3);
	Button left4 = new JoystickButton(left, 4);
	Button left5 = new JoystickButton(left, 5);
	
	public OI() {
		right1.whenPressed(new Shoot());
		right2.whileHeld(new IntakeCollect());
		right3.whileHeld(new IntakeEject());
		right4.whileHeld(new CollectorManualDown());
		right5.whileHeld(new CollectorManualUp());
		left2.whileHeld(new IntakeManualUp());
		left3.whileHeld(new IntakeManualDown());
		left4.whileHeld(new DartManualDown());
		left5.whileHeld(new DartManualUp());
	}
}

