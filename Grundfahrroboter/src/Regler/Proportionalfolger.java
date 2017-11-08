package Regler;
import Berechnung.GradCm;
import Sensoren.Lichtsensor;
import Sensoren.StandartSensor;
import lejos.robotics.RegulatedMotor;

public class Proportionalfolger {
	private StandartSensor s;
	private RegulatedMotor b;
	private RegulatedMotor c;

	public Proportionalfolger(StandartSensor s, RegulatedMotor b, RegulatedMotor c) {
		this.s = s;
		this.b = b;
		this.c = c;
	}

	public void folge(int sollwert, double p, int geschwindigkeit) {
		int diff = (int) Math.round((sollwert - s.getMessung()) * p);
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
