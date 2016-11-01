package ro.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Compute {

	int totalPrePaidSales;
	int totalPostPaidSales;

	EmployePosition position = EmployePosition.SALESMANAGER;
	EmployePosition position2 = EmployePosition.SENIORSALESOFFICER;
	EmployePosition position3 = EmployePosition.SALESOFFICER;

	public void readAndCompute() throws IOException {
		
		Path path = Paths.get("sales-team.txt");
		Charset charset = StandardCharsets.UTF_8;

		String content = new String(Files.readAllBytes(path), charset);
		content = content.replace("||", "|0|0");
		Files.write(path, content.getBytes(charset));

		File txt = new File("sales-team.txt");

		TXTFileReader txtReader = new TXTFileReader(new FileReader(txt));

		for (Employe emp : txtReader.readEmployes()) {

			if (emp.jobPosition.equals(position2.getPosition())) {
				System.out.println(emp.name + " " + (emp.workedHours * position2.getSalary()
						+ emp.prePaidSales * position2.getPrePaid() + emp.postPaidSales * position2.getPostPaid()));

				totalPrePaidSales = emp.prePaidSales;
				totalPostPaidSales = emp.postPaidSales;
			}

			if (emp.jobPosition.equals(position3.getPosition())) {
				System.out.println(emp.name + " " + (emp.workedHours * position3.getSalary()
						+ emp.prePaidSales * position3.getPrePaid() + emp.postPaidSales * position3.getPostPaid()));

				totalPrePaidSales += emp.prePaidSales;
				totalPostPaidSales += emp.postPaidSales;

			}

			txtReader.close();

		}

	}

	public void listManagers() throws IOException {

		File txt2 = new File("sales-team.txt");

		TXTFileReader txtReader2 = new TXTFileReader(new FileReader(txt2));

		for (Employe emp2 : txtReader2.readEmployes()) {

			if (emp2.jobPosition.equals(position.getPosition())) {
				System.out.println(emp2.name + " " + (emp2.workedHours * position.getSalary()
						+ totalPrePaidSales * position.getPrePaid() + totalPostPaidSales * position.getPostPaid()));
			}
		}

		txtReader2.close();
	}

}
