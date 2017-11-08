package Regler;

import Sensoren.StandartSensor;

public class PID {
	private int mittelwert;
	private int geschwindigkeit;
	private StandartSensor licht;
	private PRegler p;
	private IRegler i;
	private DRegler d;

	public PID(int mittelwert, int geschwindigkeit, StandartSensor licht, double kp, double ki, double kd) {
		this.mittelwert = mittelwert;
		this.geschwindigkeit = geschwindigkeit;
		this.licht = licht;
		p = new PRegler(kp);
		i = new IRegler(ki, mittelwert);
		d = new DRegler(kd);
	}
	
	private double regelPID() {
		int diff = mittelwert-licht.getMessung();
		double regelung = p.regelP(diff) + i.regelI(diff) + d.regelD(diff);
		return regelung;
	}
}
