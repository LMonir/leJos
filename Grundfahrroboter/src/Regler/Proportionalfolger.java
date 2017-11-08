package Regler;
import Berechnung.GradCm;
import Sensoren.Lichtsensor;
import lejos.robotics.RegulatedMotor;

public class Proportionalfolger {
	private Lichtsensor licht;
	private RegulatedMotor b;
	private RegulatedMotor c;

	public Proportionalfolger(Lichtsensor licht, RegulatedMotor b, RegulatedMotor c) {
		this.licht = licht;
		this.b = b;
		this.c = c;
	}

	public void folge(int sollwert, double p, int geschwindigkeit) {
		int diff = (int) Math.round((sollwert - licht.getLicht()) * p);
		b.setSpeed(geschwindigkeit - diff);
		c.setSpeed(geschwindigkeit + diff);
		b.forward();
		c.forward();
	}

	public void folgeCm(int sollwert, double p, int geschwindigkeit, double cm, GradCm grcm) {
		b.resetTachoCount();
		while (b.getTachoCount() < grcm.getGrad(cm)) {
			folge(sollwert, p, geschwindigkeit);
		}
		b.setSpeed(0);
		c.setSpeed(0);
		b.stop();
		c.stop();
	}
}
