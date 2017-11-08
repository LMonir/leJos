import Berechnung.GradCm;
import Fahren.Drehen;
import Fahren.FahrenCm;
import Regler.Proportionalfolger;
import Sensoren.Lichtsensor;
import ServerClient.Client;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Roboter {
	private double durchmesser;
	private Proportionalfolger folger;
	private FahrenCm fahren;
	private Drehen drehen;
	private GradCm grcm;
	private RegulatedMotor b;
	private RegulatedMotor c;
	private Lichtsensor licht1;
	private Client client;
		
	public Roboter (double durchmesser) {
		client = new Client("192.168.178.24", 6000);
		this.setDurchmesser(durchmesser);
		b = new EV3LargeRegulatedMotor(MotorPort.B);
		c = new EV3LargeRegulatedMotor(MotorPort.C);
		licht1 = new Lichtsensor(1);
		folger = new Proportionalfolger(licht1, b, c);
		fahren = new FahrenCm(durchmesser, b, c);
		drehen = new Drehen(b, c, 3);
		grcm = new GradCm(durchmesser);
	}
	
	public void folge(int sollwert, double p, int geschwindigkeit) {
		folger.folge(sollwert, p, geschwindigkeit);
	}
	public void folgeCm(int sollwert, double p, int geschwindigkeit, double cm) {
		folger.folgeCm(sollwert, p, geschwindigkeit, cm, grcm);
	}
	
	public void fahre(double cm, int speed) {
		fahren.fahreCm(cm, speed);
	}
		
	public void drehen(int grad, boolean rechts) {
		drehen.drehen(grad, rechts);
	}

	public double getDurchmesser() {
		return durchmesser;
	}

	public void setDurchmesser(double durchmesser) {
		this.durchmesser = durchmesser;
	}
	
	public void sendeServer(String anfrage) {
		client.sendeAnfrage(anfrage);
	}
}
