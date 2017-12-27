import control.PID;
import lejos.hardware.Audio;
import lejos.hardware.LED;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import sensors.Lightsensor;
import wait.WaitFor;

public class Main {

	public static void main(String[] args) {
		LED led = LocalEV3.get().getLED();
		//Roboter robo = new Roboter(49.4);
		led.setPattern(7);

		Audio audio = LocalEV3.get().getAudio();
		audio.setVolume(20);
		audio.playTone(1200, 100);
		RegulatedMotor b;
		RegulatedMotor c;	
		b = new EV3LargeRegulatedMotor(MotorPort.B);
		c = new EV3LargeRegulatedMotor(MotorPort.C);
		Lightsensor licht = new Lightsensor(1);
		PID pid = new PID(50, licht, 0.5, 0.2, 0.8, b, c);
		pid.drivePID(150);
		WaitFor.Degree(b, 1500, ">=");
		pid.stopPID();
		System.exit(0);
	}
}
