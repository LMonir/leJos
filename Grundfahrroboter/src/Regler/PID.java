package Regler;

import Fahren.Fahren;
import Sensoren.StandartSensor;
import Warten.WartenAuf;
import lejos.robotics.RegulatedMotor;

public class PID extends Thread {
	private RegulatedMotor b;
	private Fahren drive;
	private int mittelwert;
	private int geschwindigkeit;
	private StandartSensor licht;
	private PRegler p;
	private IRegler i;
	private DRegler d;
	private boolean stop;

	public PID(int mittelwert, int geschwindigkeit, StandartSensor licht, double kp, double ki, double kd,
			RegulatedMotor b, RegulatedMotor c) {
		this.b = b;
		drive = new Fahren(b, c);
		this.mittelwert = mittelwert;
		this.geschwindigkeit = geschwindigkeit;
		this.licht = licht;
		p = new PRegler(kp);
		i = new IRegler(ki, mittelwert);
		d = new DRegler(kd);
	}

	public void run() {
		stop = false;
		while (!stop) {
			int diff = mittelwert - licht.getMessung();
			double regelung = p.regelP(diff) + i.regelI(diff) + d.regelD(diff);
			drive.setSpeedB((int) Math.round(geschwindigkeit + regelung));
			drive.setSpeedC((int) Math.round(geschwindigkeit - regelung));
		}
	}

	public void drivePID() {
		drive.start(geschwindigkeit);
		start();
		WartenAuf.Grad(b, 600, ">=");
		drive.stopDrive();
		stop = true;
	}
}
