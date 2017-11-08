package Regler;

public class IRegler {
	private double ki;
	private double diffSum;
	private int diffAlt;
	private int mittelwert;

	public IRegler(double ki, int mittelwert) {
		this.ki = ki;
		diffSum = 0;
		diffAlt = 0;
		this.mittelwert = mittelwert;
	}
	public double regelI(int diff) {
		diffSum = diffSum * 0.997 + diff;
		
		if (diff*diffAlt < 0) {
			diffSum = 0;
		}
		
		diffAlt = diff;
		
		return diffSum * ki * (diff/mittelwert);
	}
}
