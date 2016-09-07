package scoalainformala.metricdistancecalculator;

import static org.junit.Assert.*;

import org.junit.Test;


public class MetricDistanceCalculatorTest {

	public void simpleExpressionIsCalculated() {
		// given
		MetricDistanceExpressionParser mockParser = new MetricDistanceExpressionParser(){
			@Override
			public Distance[] parse(String expression) {
				return new Distance[]{new Distance(Distance.KILO_METERS, 1), new Distance(Distance.METERS, 1)};
			}	
		};
		MetricDistanceConverter mockConverter = new MetricDistanceConverter(){
			@Override
			public Distance convert(Distance distance, String toFormat) {
				if(distance.getFormatName().equals(Distance.KILO_METERS)){
					return new Distance(Distance.METERS, 1000);
				} else {
					return distance;
				}
			}
		};
		MetricDistanceCalculator calc = new MetricDistanceCalculator(mockParser, mockConverter);
		
		// when
		Distance actual = calc.computeDistance("1km+1km", Distance.METERS);
		
		// then
		Distance expected = new Distance(Distance.METERS, 1001);
		assertEquals(expected, actual);
	}

}
