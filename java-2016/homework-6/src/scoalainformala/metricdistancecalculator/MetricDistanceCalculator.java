package scoalainformala.metricdistancecalculator;

public class MetricDistanceCalculator {

	private MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();

	public Distance computeDistance(String expression, String resultDistanceFormat) {
		Distance[] dist = parser.parse(expression);
		Distance result = new Distance(resultDistanceFormat, 0);
		MetricDistanceConverter converter = new MetricDistanceConverter();
		for (Distance distance : dist) {
			Distance converted = converter.convert(distance, resultDistanceFormat);
			result.add(converted.getValue());
		}
		return result;
	}

}
