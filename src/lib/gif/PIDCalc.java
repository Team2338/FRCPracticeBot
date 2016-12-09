package lib.gif;

import edu.wpi.first.wpilibj.Timer;

public class PIDCalc {
	
	double kP;
	double kI;
	double kD;
	double setpoint;
	double error;
	double speed;
	double lastTime;
	double lastCycleDistance;
	
	public PIDCalc(double kP, double kI, double kD) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
	}
	
	public void setSetpoint(double setpoint) {
		this.setpoint = setpoint;
	}
	
	public double output(double encoder) {
		
		error = setpoint - encoder;
		double pOut = error * kP;
		double iOut;
		double dOut;
		double iAccum = 0;
		
		iAccum += pOut;
		
		iOut = iAccum * kI;
		
		speed = (lastCycleDistance - error)/(Timer.getFPGATimestamp() - lastTime);
		
		dOut = speed * kD;
		
		lastTime = Timer.getFPGATimestamp();
		lastCycleDistance = error;
		
		return pOut + iOut - dOut;
	}
}
