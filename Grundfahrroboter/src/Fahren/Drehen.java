package Fahren;

import Sensoren.Gyrosensor;
import lejos.robotics.RegulatedMotor;

public class Drehen {
	private Gyrosensor gyro;
	private RegulatedMotor b;
	private RegulatedMotor c;

	public Drehen(RegulatedMotor b, RegulatedMotor c, int port) {
		this.b = b;
		this.c = c;
		gyro = new Gyrosensor(port);
	}

	public void drehen(int grad, boolean rechts) {
		int speed = (int) Math.round(grad - Math.abs(gyro.getGrad())) + 30;
		gyro.reset();
		b.resetTachoCount();
		c.resetTachoCount();
		b.setSpeed(speed);
		c.setSpeed(speed);
		if (rechts) {
			b.forward();
			c.backward();
		} else {
			c.forward();
			b.backward();
		}
		while (grad - Math.abs(gyro.getGrad()) > 2) {
			speed = (int) Math.round(grad - Math.abs(gyro.getGrad())) + 30;

			b.setSpeed(speed * 2);
			c.setSpeed(speed * 2);
		}
		b.setSpeed(0);
		c.setSpeed(0);

	}

}
