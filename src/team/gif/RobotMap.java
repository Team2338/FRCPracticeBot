package team.gif;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static int frontLeft = 9;
	public static int frontRight = 5;
	public static int rearLeft = 10;
	public static int rearRight = 6;
	public static int rightEncoderOne = 0;
	public static int rightEncoderTwo = 1;
	public static int leftEncoderOne = 2;
	public static int leftEncoderTwo = 3;
	
	public static int collector = 1;
	public static int shooterPolycord = 3;
	public static int collectorAngleOne = 4;
	public static int collectorAngleTwo = 11;
	public static int shooterAngle = 8;
	public static int flyWheelOne = 2;
	public static int flyWheelTwo = 7;
}
