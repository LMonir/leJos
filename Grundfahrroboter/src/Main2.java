import Berechnung.GradCm;
import Fahren.Drehen;
import Fahren.FahrenCm;
import Regler.Proportionalfolger;
import Sensoren.Lichtsensor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Main2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GradCm grcm = new GradCm(49.4);
		RegulatedMotor b;
		RegulatedMotor c;
		b = new EV3LargeRegulatedMotor(MotorPort.B);
		c = new EV3LargeRegulatedMotor(MotorPort.C);
		Lichtsensor licht1 = new Lichtsensor(1);
		
		Proportionalfolger folger = new Proportionalfolger(licht1, b, c);
		FahrenCm drive = new FahrenCm(49.4, b, c);
		Drehen drehen = new Drehen(b, c, 3);
		//while(true) {folger.folge(25, 2, 200);}
		//drive.fahreCm(10, 800);
		//System.out.println("Moin");
		drehen.drehen(90, false);
		drehen.drehen(90, true);
		drehen.drehen(90, false);
		drehen.drehen(90, true);
		//drive.fahreCm(10, 350);
		//folger.folgeCm(25, 2, 200, 50, grcm);
	}

}
