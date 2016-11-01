package ro.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TXTFileReader extends BufferedReader {

	public TXTFileReader(Reader reader) {
		super(reader);
	}

	public List<Employe> readEmployes() throws IOException {

		String txtLine = readLine();
		ArrayList<Employe> employes = new ArrayList<>();

		while (txtLine != null) {

			String[] tokens = txtLine.split("\\|");
			Employe employe = new Employe();
			employe.setName(tokens[0]);
			employe.setJobPosition(tokens[1]);
			employe.setWorkedHours(Integer.parseInt(tokens[2]));
			employe.setDaysOff(Integer.parseInt(tokens[3]));
			employe.setPrepaidSales(Integer.parseInt(tokens[4]));
			employe.setPostpaidSales(Integer.parseInt(tokens[5]));
			employes.add(employe);
			txtLine = readLine();
		}
		return employes;
	}

}
