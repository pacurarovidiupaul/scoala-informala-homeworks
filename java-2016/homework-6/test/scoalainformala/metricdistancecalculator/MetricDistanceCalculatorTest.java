package scoalainformala.metricdistancecalculator;

import org.junit.Assert;
import org.junit.Test;

public class MetricDistanceCalculatorTest {

	@Test
	public void simpleExpressionIsCalculated() throws UnknownDistanceFormatException {

		MetricDistanceExpressionParser mockParser = new MetricDistanceExpressionParser() {
			@Override
			public Distance[] parse(String expression)  {
				return new Distance[] { new Distance(Distance.KILO_METERS, 1), new Distance(Distance.METERS, 1) };
			}
		};
		MetricDistanceConverter mockConverter = new MetricDistanceConverter() {
			@Override
			public Distance convert(Distance distance, String toFormat)  {
				if (distance.getFormatName().equals(Distance.KILO_METERS)) {
					return new Distance(Distance.METERS, 1000);
				} else {
					return distance;
				}
			}
		};
		MetricDistanceCalculator calc = new MetricDistanceCalculator(mockParser, mockConverter);

		Distance actual = calc.computeDistance("1km+1km", Distance.METERS);

		Distance expected = new Distance(Distance.METERS, 1001);
		Assert.assertEquals(expected, actual);
	}

}
