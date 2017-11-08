package Regler;
import Sensoren.Lichtsensor;

public class PID {
	private double pk;
	private double ik;
	private double dk;
	private int sollwert;
	private int v;
	private Lichtsensor light;
	private int diff;
	private double diffsum;
	private int diffalt;

	public PID(double pk, double ik, double dk, int port, int sollwert, int v) {
		this.pk = pk;
		this.ik = ik;
		this.dk = dk;
		this.sollwert = sollwert;
		this.v = v;
		light = new Lichtsensor(port);

	}

	private float diff() {
		return sollwert - light.getLicht();
	}

	private double pRegler() {
		double pRegler = 0;
		pRegler = pk * diff;
		return pRegler;
	}

	private double iRegler() {
		double iRegler = 0;
		return iRegler;
	}

}
