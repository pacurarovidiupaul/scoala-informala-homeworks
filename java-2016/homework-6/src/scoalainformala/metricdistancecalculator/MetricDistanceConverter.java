package scoalainformala.metricdistancecalculator;

public class MetricDistanceConverter {

	private static final Convertion[] CONVERTIONS = new Convertion[] {
			new Convertion(Distance.MILIMETERS, Distance.METERS, 0.001),
			new Convertion(Distance.CENTIMETERS, Distance.METERS, 0.01),
			new Convertion(Distance.DECAMETERS, Distance.METERS, 0.1),
			new Convertion(Distance.KILO_METERS, Distance.METERS, 1000d),
			new Convertion(Distance.INCH, Distance.METERS, 0.0254),
			new Convertion(Distance.FOOT, Distance.METERS, 0.3048),
			new Convertion(Distance.MILES, Distance.METERS, 1609.344)

	};

	public Distance convert(Distance distance, String toFormat) {
		if (distance.getFormatName().equals(toFormat)) {
			return distance;
		}

		Convertion convertion = null;
		for (Convertion c : CONVERTIONS) {
			if (c.fromFormat.equals(distance.getFormatName()) & c.toFormat.equals(toFormat)) {
				convertion = c;
				break;
			}
		}

		if (convertion == null) {
			throw new IllegalArgumentException("No rate found for" + distance.getFormatName() + " - " + toFormat);

		}

		return new Distance(toFormat, distance.getValue() * convertion.rate);

	}

	private static class Convertion {
		double rate;
		String fromFormat;
		String toFormat;

		public Convertion(String fromFormat, String toFormat, double rate) {
			super();
			this.rate = rate;
			this.fromFormat = fromFormat;
			this.toFormat = toFormat;
		}
	}

}
