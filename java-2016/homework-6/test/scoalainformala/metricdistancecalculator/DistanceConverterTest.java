package scoalainformala.metricdistancecalculator;

import org.junit.Assert;
import org.junit.Test;

// This class tests if the conversion is working good.

public class DistanceConverterTest {

	// Testing the conversion from centimeter to meter
	@Test
	public void cmToMeterConversion() {
		Distance cm = new Distance(Distance.CENTIMETERS, 100);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();

		Distance result = distanceConverter.convert(cm, Distance.METERS);
		Distance expected = new Distance(Distance.METERS, 1);

		Assert.assertEquals("Conversion from cm to m is correct.", expected, result);

	}

	// Testing the conversion from millimeter to meter
	@Test
	public void mmToMeterConversion() {
		Distance mm = new Distance(Distance.MILIMETERS, 1000);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();

		Distance result = distanceConverter.convert(mm, Distance.METERS);
		Distance expected = new Distance(Distance.METERS, 1);

		Assert.assertEquals("Conversion from cm to m is correct.", expected, result);

	}

	// Testing the conversion from decametre to meter
	@Test
	public void dmToMeterConversion() {
		Distance dm = new Distance(Distance.DECAMETERS, 10);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();

		Distance result = distanceConverter.convert(dm, Distance.METERS);
		Distance expected = new Distance(Distance.METERS, 1);

		Assert.assertEquals("Conversion from dm to m is correct", expected, result);
	}

	// Testing the conversion from inch to meter
	@Test
	public void inToMeterConversion() {
		Distance in = new Distance(Distance.INCH, 39.37);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();

		Distance result = distanceConverter.convert(in, Distance.METERS);
		Distance expected = new Distance(Distance.METERS, 1);

		Assert.assertEquals("Conversion from in to m is correct", expected, result);

	}

	// Testing the conversion from feet to meter

	@Test
	public void ftToMeterConversion() {
		Distance ft = new Distance(Distance.FOOT, 3.28);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();

		Distance result = distanceConverter.convert(ft, Distance.METERS);
		Distance expected = new Distance(Distance.METERS, 1);

		Assert.assertEquals("Conversion from ft to m is correct", expected, result);

	}

}
