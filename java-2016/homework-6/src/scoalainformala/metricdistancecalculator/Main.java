package scoalainformala.metricdistancecalculator;

import java.util.Scanner;

/**
 * This is a distance calculator and in the same time converter. You can make
 * add and minuses from cm, m, dm, km mi, ft and in. The result will be
 * delivered in meters.
 * 
 * @author Pacurar Ovidiu Paul
 *
 */

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Input your numbers (eg. 2mi+1km-3in): ");
		String total = input.next();
		input.close();
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		System.out.println(calc.computeDistance(total, Distance.METERS));
	}

}
