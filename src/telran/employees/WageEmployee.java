package telran.employees;

public class WageEmployee extends Employee {

	private int wage;
	private int hours;

	public WageEmployee(long id, int basicSalary, String department) {
		super(id, basicSalary, department);
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public int computeSalary() {

		return super.computeSalary() + wage * hours;
	}

}
