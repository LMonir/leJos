import Fahren.Fahren;
import Fahren.FahrenCm;
import Regler.PID;
import Sensoren.Lichtsensor;
import Warten.WartenAuf;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Main4 {	
	public static void main(String[] args) {
		RegulatedMotor b;
		RegulatedMotor c;	
		b = new EV3LargeRegulatedMotor(MotorPort.B);
		c = new EV3LargeRegulatedMotor(MotorPort.C);
		Lichtsensor licht = new Lichtsensor(1);
		PID pid = new PID(50, 150, licht, 0.5, 0.2, 0.8, b, c);
		pid.drivePID();
		System.exit(0);
	}

}
