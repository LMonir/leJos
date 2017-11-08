package Fahren;

import lejos.robotics.RegulatedMotor;

public class Fahren extends Thread {
	private RegulatedMotor b;
	private RegulatedMotor c;	
	private boolean stop = false;
	private int speedB = 0;
	private int speedC = 0;
	private boolean regulate;

	public Fahren(RegulatedMotor b, RegulatedMotor c) {
		this.b = b;
		this.c = c;
		this.regulate = true;
	}

	public void run() {
		stop = false;
		b.resetTachoCount();
		c.resetTachoCount();
		b.setSpeed(speedB);
		c.setSpeed(speedC);
		while (!stop) {
			if (regulate) {
				if (b.getTachoCount() < c.getTachoCount()) {
					b.setSpeed(speedB + 1);
					c.setSpeed(speedC);
				} else if (b.getTachoCount() > c.getTachoCount()) {
					c.setSpeed(speedC + 1);
					b.setSpeed(speedB);
				} else {
					b.setSpeed(speedB);
					c.setSpeed(speedC);
				}
			}
		}
		b.setSpeed(0);
		c.setSpeed(0);
	}

	public void start(int speed) {
		this.speedB = speed;
		this.speedC = speed;
		start();
	}

	public void start(int speedB, int speedC) {
		this.speedB = speedB;
		this.speedC = speedC;
		start();
	}

	public void setSpeed(int speed) {
		this.speedB = speed;
		this.speedC = speed;
	}

	public void setSpeedB(int speed) {
		this.speedB = speed;
	}

	public void setSpeedC(int speed) {
		this.speedC = speed;
	}

	public int getSpeedB() {
		return speedB;
	}

	public int getSpeedC() {
		return speedC;
	}

	public void setRegulation(boolean regulate) {
		this.regulate = regulate;
	}
	
	public boolean getRegulation() {
		return regulate;
	}
	
	public void stopDrive() {
		stop = true;
	}

}
