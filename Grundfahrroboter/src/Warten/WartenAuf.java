package Warten;

import Sensoren.Gyrosensor;
import Sensoren.Lichtsensor;
import lejos.robotics.RegulatedMotor;

public class WartenAuf {

	public static void Licht(Lichtsensor licht, int lichtlvl, String vergleich){
		boolean check = false;		
		while (!check) {
			System.out.println(licht.getLicht());
			switch (vergleich) {
			case "=":
				if (licht.getLicht()==lichtlvl) {check = true;}
				break;
			case "<":
				if (licht.getLicht()<lichtlvl) {check = true;}
				break;
			case "<=":
				if (licht.getLicht()<=lichtlvl) {check = true;}
				break;
			case ">":
				if (licht.getLicht()>lichtlvl) {check = true;}
				break;
			case ">=":
				if (licht.getLicht()>=lichtlvl) {check = true;}
				break;
			case "!=":
				if (licht.getLicht()!=lichtlvl) {check = true;}
				break;
			default:
				check = true;
			}
		}
	}	
	
	public static void Gyro(Gyrosensor gyro, int gyrolvl, String vergleich){
		boolean check = false;		
		while (!check) {
			switch (vergleich) {
			case "=":
				if (gyro.getGrad()==gyrolvl) {check = true;}
				break;
			case "<":
				if (gyro.getGrad()<gyrolvl) {check = true;}
				break;
			case "<=":
				if (gyro.getGrad()<=gyrolvl) {check = true;}
				break;
			case ">":
				if (gyro.getGrad()>gyrolvl) {check = true;}
				break;
			case ">=":
				if (gyro.getGrad()>=gyrolvl) {check = true;}
				break;
			case "!=":
				if (gyro.getGrad()!=gyrolvl) {check = true;}
				break;
			default:
				check = true;	
			}
		}
	}
	
	public static void Grad(RegulatedMotor motor, int gradlvl, String vergleich){
		boolean check = false;		
		while (!check) {
			switch (vergleich) {
			case "=":
				if (motor.getTachoCount()==gradlvl) {check = true;}
				break;
			case "<":
				if (motor.getTachoCount()<gradlvl) {check = true;}
				break;
			case "<=":
				if (motor.getTachoCount()<=gradlvl) {check = true;}
				break;
			case ">":
				if (motor.getTachoCount()>gradlvl) {check = true;}
				break;
			case ">=":
				if (motor.getTachoCount()>=gradlvl) {check = true;}
				break;
			case "!=":
				if (motor.getTachoCount()!=gradlvl) {check = true;}
				break;
			default:
				check = true;	
			}
		}
	}	
}
