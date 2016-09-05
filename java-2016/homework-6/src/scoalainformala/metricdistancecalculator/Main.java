package scoalainformala.metricdistancecalculator;

public class Main {

	public static void main(String[] args) {
		String total = "10mm + 2km - 1in + 1mi + 1ft - 34cm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		System.out.println(calc.computeDistance(total, Distance.METERS));
	}

}
