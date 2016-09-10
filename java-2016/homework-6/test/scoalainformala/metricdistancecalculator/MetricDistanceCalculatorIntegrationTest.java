package scoalainformala.metricdistancecalculator;

import org.junit.Assert;
import org.junit.Test;

public class MetricDistanceCalculatorIntegrationTest {

	@Test
	public void distanceCalculatorWorksWithCorrectInput() throws UnknownDistanceFormatException {
		String s = "1km+1.05km";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		Distance result = calc.computeDistance(s, Distance.KILO_METERS);
		Distance expected = new Distance(Distance.KILO_METERS, 2.05);
		Assert.assertEquals(expected, result);
	}

}
