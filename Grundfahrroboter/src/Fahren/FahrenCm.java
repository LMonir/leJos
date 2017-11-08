package Fahren;

import Berechnung.GradCm;
import lejos.robotics.RegulatedMotor;

public class FahrenCm extends GradCm {

	private RegulatedMotor b;
	private RegulatedMotor c;
	private Fahren drive;
	private static final int DIFF = 100;

	public FahrenCm(double durchmesser, RegulatedMotor b, RegulatedMotor c) {
		super(durchmesser);
		this.b = b;
		this.c = c;
		drive = new Fahren(b,c);
	}

	public void fahreCm(double cm, int speed) {
		int minspeed = 5;		
		double grad = getGrad(cm);
		drive.start(minspeed);
		
		while (b.getTachoCount() < grad - DIFF) {
			if (minspeed < speed - 20) {
				minspeed += 10;
				drive.setSpeed(minspeed);	
			}					
		}
		long sub = Math.round((minspeed / DIFF)) + 1;
		
		while (b.getTachoCount() < grad) {
			if (minspeed > sub) {
				minspeed -= sub;
			} else {
				minspeed = (int) sub * 6;
			}
			drive.setSpeed(minspeed);	
		}
		drive.stopDrive();
	}

	public void fahreCm(double cm, int speed, boolean invert) {
		int minspeed = 5;
		int str = 1;
		double grad = getGrad(cm);

		b.resetTachoCount();
		c.resetTachoCount();
		b.setSpeed(minspeed);
		c.setSpeed(minspeed);
		if (invert) {
			b.backward();
			c.backward();
		} else {
			b.forward();
			c.forward();
		}

		while (Math.abs(b.getTachoCount()) < grad - DIFF) {
			if (minspeed < speed - 20) {
				minspeed += 10;
			}

			if (Math.abs(b.getTachoCount()) < Math.abs(c.getTachoCount())) {
				b.setSpeed(minspeed + str);
				c.setSpeed(minspeed);
			} else if (Math.abs(b.getTachoCount()) > Math.abs(c.getTachoCount())) {
				c.setSpeed(minspeed + str);
				b.setSpeed(minspeed);
			} else {
				b.setSpeed(minspeed);
				c.setSpeed(minspeed);
			}
		}

		long sub = Math.round((minspeed / DIFF)) + 1;

		while (Math.abs(b.getTachoCount()) < grad) {
			if (minspeed > sub + 20) {
				minspeed -= sub;
			}

			if (Math.abs(b.getTachoCount()) < Math.abs(c.getTachoCount())) {
				b.setSpeed(minspeed + str);
				c.setSpeed(minspeed);
			} else if (Math.abs(b.getTachoCount()) > Math.abs(c.getTachoCount())) {
				c.setSpeed(minspeed + str);
				b.setSpeed(minspeed);
			} else {
				b.setSpeed(minspeed);
				c.setSpeed(minspeed);
			}
		}

		b.setSpeed(0);
		c.setSpeed(0);
		b.stop();
		c.stop();
	}
}
