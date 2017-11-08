import lejos.hardware.Audio;
import lejos.hardware.LED;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Main {

	public static void main(String[] args) {
		LED led = LocalEV3.get().getLED();
		Roboter robo = new Roboter(49.4);
		led.setPattern(7);
		try {
			Audio audio = LocalEV3.get().getAudio();
			audio.setVolume(50);
			audio.playTone(1200, 100);
			//robo.sendeServer("Hallo Welt!");
			//Delay.msDelay(10000);
			robo.fahre(20, -700);
			//robo.drehen(60, false);
			//robo.fahre(15, 500);
			//robo.drehen(50, false);
			//robo.fahre(36, 500);
			//robo.drehen(45, false);
			//robo.folgeCm(25, 2, 200, 45);
			
			
		} catch (java.lang.IllegalArgumentException e) {
			int index = 0;
			String str = "";
			String s = "" + e;
			index = s.indexOf(":");
			s = s.substring(index + 2);
			switch (s) {
			case "Invalid sensor mode":
				str = "Port nicht vorhanden!\nUeberpruefe die Ports!";
			case "unable to open port":
				str = "Port wird benutzt!\nUeberpruefe die Ports!";
			}
			led.setPattern(2);
			System.out.println(str);
			LCD.clearDisplay();
			LCD.drawString(str, 0, 0);
			Delay.msDelay(5000);
		} catch (lejos.hardware.DeviceException e) {
			int index = 0;
			String str = "";
			String s = "" + e;
			index = s.indexOf(":");
			s = s.substring(index + 2);
			switch (s) {
			case "unable to open port":
				str = "Port wird benutzt!\nUeberpruefe die Ports!";
			}
			led.setPattern(2);
			System.out.println(str);
			LCD.clearDisplay();
			LCD.drawString(str, 0, 0);
			Delay.msDelay(5000);
		}
	}

}
