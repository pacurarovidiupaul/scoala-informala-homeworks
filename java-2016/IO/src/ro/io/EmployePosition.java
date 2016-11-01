package ro.io;

public class EmployePosition {

	public static final EmployePosition SALESMANAGER = new EmployePosition("Sales Manager", 40, 15, 30);
	public static final EmployePosition SENIORSALESOFFICER = new EmployePosition("Senior Sales Officer", 20, 25, 50);
	public static final EmployePosition SALESOFFICER = new EmployePosition("Sales Officer", 10, 10, 25);

	private String position;
	private int salary;
	private int prepaid;
	private int postpaid;

	private EmployePosition(String position, int salary, int prepaid, int postpaid) {
		super();
		this.position = position;
		this.salary = salary;
		this.prepaid = prepaid;
		this.postpaid = postpaid;

	}

	public String getPosition() {
		return position;
	}

	public int getSalary() {
		return salary;
	}

	public int getPostPaid() {
		return postpaid;
	}

	public int getPrePaid() {
		return prepaid;
	}

}
