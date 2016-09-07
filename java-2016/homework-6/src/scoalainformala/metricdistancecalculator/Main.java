package scoalainformala.metricdistancecalculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Input your numbers (eg. 2mi+1km-3in): ");
		String total = input.next();
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		System.out.println(calc.computeDistance(total, Distance.METERS));
	}

}
