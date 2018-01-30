
import lejos.hardware.Audio;
import lejos.hardware.LED;
import lejos.hardware.ev3.LocalEV3;

public class Main4 {	
	public static void main(String[] args) {
		LED led = LocalEV3.get().getLED();
		Roboter robo = new Roboter(43);
		led.setPattern(6);
		
		Audio audio = LocalEV3.get().getAudio();
		audio.setVolume(20);
		audio.playTone(1200, 100);
		led.setPattern(7);
		
		for(int i = 0; i < 4; i++) {
			robo.driveCm(30, 300);
			robo.turn(90, true);
		}
		
		System.exit(0);
	}

}
