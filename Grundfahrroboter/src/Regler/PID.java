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
			double regelung = Math.round(p.regelP(diff) + i.regelI(diff) + d.regelD(diff));
			drive.setSpeedB((int) (geschwindigkeit + regelung));
			drive.setSpeedC((int) (geschwindigkeit - regelung));
			System.out.println(regelung);
		}
	}

	public void drivePID() {
		drive.setDirection('f');
		drive.start(geschwindigkeit);
		start();
		WartenAuf.Grad(b, 1500, ">=");
		drive.stopDrive();
		stop = true;
	}
}
