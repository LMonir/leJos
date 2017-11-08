package Fahren;

import lejos.robotics.RegulatedMotor;

public class Fahren extends Thread{
	private RegulatedMotor b;
	private RegulatedMotor c;
	private boolean stop = false;
	private int speed = 0;

	public Fahren(RegulatedMotor b, RegulatedMotor c) {
		this.b = b;
		this.c = c;
	}

	public void run() {
		stop = false;
		b.resetTachoCount();
		c.resetTachoCount();
		b.setSpeed(speed);
		c.setSpeed(speed);		
		while (!stop) {
			if (b.getTachoCount() < c.getTachoCount()) {
				b.setSpeed(speed + 1);
				c.setSpeed(speed);
			} else if (b.getTachoCount() > c.getTachoCount()) {
				c.setSpeed(speed + 1);
				b.setSpeed(speed);
			} else {
				b.setSpeed(speed);
				c.setSpeed(speed);
			}
		}		
		b.setSpeed(0);
		c.setSpeed(0);
	}
	public void start(int speed) {
		this.speed = speed;
		start();
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeed() {
		return speed;
	}
	public void stopDrive() {
		stop = true;
	}

}
