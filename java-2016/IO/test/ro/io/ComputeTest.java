package ro.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ComputeTest {

	File txt = new File("sales-team.txt");
	EmployePosition salesManager = EmployePosition.SALESMANAGER;
	EmployePosition seniorOfficer = EmployePosition.SENIORSALESOFFICER;
	EmployePosition salesOfficer = EmployePosition.SALESOFFICER;

	int totalPrePaidSales;
	int totalPostPaidSales;

	@Test
	public void getManagerSalary() throws IOException {

		int result = 0;
		int expected = 0;

		TXTFileReader txtReader = new TXTFileReader(new FileReader(txt));

		for (Employe emp : txtReader.readEmployes()) {

			if (emp.jobPosition.equals(salesManager.getPosition())) {
				result = emp.workedHours * salesManager.getSalary();
				expected = emp.workedHours * 40;
			}
		}

		Assert.assertEquals("Salary is:", expected, result);
		txtReader.close();
	}

	@Test
	public void getSeniorSalesSalary() throws IOException {

		int result = 0;
		int expected = 0;

		TXTFileReader txtReader = new TXTFileReader(new FileReader(txt));

		for (Employe emp : txtReader.readEmployes()) {

			if (emp.jobPosition.equals(seniorOfficer.getPosition())) {
				result = emp.workedHours * seniorOfficer.getSalary();
				expected = emp.workedHours * 20;
			}

		}

		Assert.assertEquals("Salary is:", expected, result);
		txtReader.close();

	}

	@Test
	public void getOfficerSalesSalary() throws IOException {

		int result = 0;
		int expected = 0;

		TXTFileReader txtReader = new TXTFileReader(new FileReader(txt));

		for (Employe emp : txtReader.readEmployes()) {

			if (emp.jobPosition.equals(salesOfficer.getPosition())) {
				result = emp.workedHours * salesOfficer.getSalary();
				expected = emp.workedHours * 10;
			}

		}

		Assert.assertEquals("Salary is:", expected, result);
		txtReader.close();
	}

	@Test
	public void getSeniorBonus() throws IOException {

		int result = 0;
		int expected = 0;

		TXTFileReader txtReader = new TXTFileReader(new FileReader(txt));

		for (Employe emp : txtReader.readEmployes()) {

			if (emp.jobPosition.equals(seniorOfficer.getPosition())) {
				result = emp.postPaidSales * seniorOfficer.getPostPaid()
						+ emp.prePaidSales * seniorOfficer.getPrePaid();

				expected = emp.postPaidSales * 50 + emp.prePaidSales * 25;
			}

		}

		Assert.assertEquals("Bonus is:", expected, result);
		txtReader.close();

	}

	@Test
	public void getSalesOfficerBonus() throws IOException {

		int result = 0;
		int expected = 0;

		TXTFileReader txtReader = new TXTFileReader(new FileReader(txt));

		for (Employe emp : txtReader.readEmployes()) {

			if (emp.jobPosition.equals(salesOfficer.getPosition())) {
				result = emp.postPaidSales * salesOfficer.getPostPaid() + emp.prePaidSales * salesOfficer.getPrePaid();

				expected = emp.postPaidSales * 25 + emp.prePaidSales * 10;
			}

		}

		Assert.assertEquals("Bonus is:", expected, result);
		txtReader.close();

	}

	@Test
	public void getManagerBonus() throws IOException {

		int result = 0;
		int expected = 0;

		TXTFileReader txtReader = new TXTFileReader(new FileReader(txt));

		for (Employe emp : txtReader.readEmployes()) {

			if (emp.jobPosition.equals(salesManager.getPosition())) {
				result = 25 * salesManager.getPostPaid() + 25 * salesManager.getPrePaid();
				expected = 25 * 30 + 25 * 15;
			}

		}

		Assert.assertEquals("Bonus is:", expected, result);
		txtReader.close();

	}

}
