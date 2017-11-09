package Fahren;

import Sensoren.Gyrosensor;
import lejos.robotics.RegulatedMotor;

public class Drehen {	

	public static void drehen(int grad, boolean rechts, RegulatedMotor b, RegulatedMotor c, Gyrosensor gyro) {
		Fahren drive = new Fahren(b, c);
		int speed = grad - Math.abs(gyro.getMessung()) + 30;
		gyro.reset();
		if (rechts) {
			drive.setDirection(Fahren.RIGHT);
		} else {
			drive.setDirection(Fahren.LEFT);
		}
		drive.start(speed);
		while (grad - Math.abs(gyro.getMessung()) > 2) {
			speed = grad - Math.abs(gyro.getMessung()) + 30;
			drive.setSpeed(speed);
		}
		drive.stopDrive();
	}

}
