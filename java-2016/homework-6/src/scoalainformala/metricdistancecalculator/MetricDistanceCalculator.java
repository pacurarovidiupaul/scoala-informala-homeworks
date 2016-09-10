package scoalainformala.metricdistancecalculator;

public class MetricDistanceCalculator {

	private MetricDistanceExpressionParser parser;
	@SuppressWarnings("unused")
	private MetricDistanceConverter converter;

	public MetricDistanceCalculator() {
		this(new MetricDistanceExpressionParser(), new MetricDistanceConverter());
	}

	MetricDistanceCalculator(MetricDistanceExpressionParser parser, MetricDistanceConverter converter) {
		this.parser = parser;
		this.converter = converter;
	}

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
