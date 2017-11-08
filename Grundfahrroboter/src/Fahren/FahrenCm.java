package Fahren;

import Berechnung.GradCm;
import lejos.robotics.RegulatedMotor;

public class FahrenCm extends GradCm {

	private RegulatedMotor b;
	private RegulatedMotor c;
	private Fahren drive;
	
	public FahrenCm(double durchmesser, RegulatedMotor b, RegulatedMotor c) {
		super(durchmesser);
		this.b = b;
		this.c = c;
		drive = new Fahren(b, c);
	}

	public void fahreCm(double cm, int speed) {
		int minspeed = 5;
		int s = 0;
		double grad = Math.abs(getGrad(cm));
		if (cm < 0 ^ speed < 0) {
			drive.setDirection('b');
		} else {
			drive.setDirection('f');
		}
		drive.start(minspeed);
		while ((minspeed < Math.abs(speed)) && (Math.abs(b.getTachoCount()) < (grad / 2))) {
			minspeed += 5;			
			drive.setSpeed(minspeed);
		}
		s = Math.abs(b.getTachoCount());
		System.out.println(b.getTachoCount());
		drive.setSpeed(minspeed);
		
		while (Math.abs(b.getTachoCount()) < (grad - s - 20)) {}

		while (Math.abs(b.getTachoCount()) < grad) {
			minspeed -= 5;
			drive.setSpeed(minspeed);
		}
		drive.stopDrive();
	}
}
