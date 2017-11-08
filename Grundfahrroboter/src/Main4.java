import Fahren.Fahren;
import Fahren.FahrenCm;
import Sensoren.Lichtsensor;
import Warten.WartenAuf;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Main4 {	
	public static void main(String[] args) {
		RegulatedMotor b;
		RegulatedMotor c;
		Lichtsensor licht1;
		licht1 = new Lichtsensor(1);
		b = new EV3LargeRegulatedMotor(MotorPort.B);
		c = new EV3LargeRegulatedMotor(MotorPort.C);
		Fahren drive = new Fahren(b,c);
		//FahrenCm drivecm = new FahrenCm(49.4, b, c);
		drive.start(100);
		WartenAuf.Licht(licht1, 10, "<=");
		drive.stopDrive();
		//drivecm.fahreCm(30, 300);
		System.exit(0);
	}

}
