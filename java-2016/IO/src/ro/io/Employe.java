package ro.io;

import java.io.Serializable;

public class Employe implements Serializable {

	private static final long serialVersionUID = 7154968642607935695L;
	String name;
	String jobPosition;
	int workedHours;
	int daysOff;
	int prePaidSales;
	int postPaidSales;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public int getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}

	public int getDaysOff() {
		return daysOff;
	}

	public void setDaysOff(int daysOff) {
		this.daysOff = daysOff;
	}

	public int getPrepaidSales() {
		return prePaidSales;
	}

	public void setPrepaidSales(int prepaidSales) {
		this.prePaidSales = prepaidSales;
	}

	public int getPostpaidSales() {
		return postPaidSales;
	}

	public void setPostpaidSales(int postpaidSales) {
		this.postPaidSales = postpaidSales;
	}

	@Override
	public String toString() {
		return "Employe [name=" + name + ", jobPosition=" + jobPosition + ", workedHours=" + workedHours + ", daysOff="
				+ daysOff + ", prepaidSales=" + prePaidSales + ", postpaidSales=" + postPaidSales + "]";
	}

}
