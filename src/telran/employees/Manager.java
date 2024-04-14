package telran.employees;

public class Manager extends Employee {
    //Constructor of class Manager must take factor (see UML schema)
	private float factor;
	private int basicSalary;
	public Manager(long id, int basicSalary, String department, float factor) {
		super(id, 10000, department);
		this.factor = factor;
		this.basicSalary = basicSalary;
		// Auto-generated constructor stub
	}
	// (see UML schema)
	public float getFactor() {
		return factor;
	}
	public void setFactor(float factor) {
		this.factor = factor;
	}
	public int getbasicSalary() {
		return basicSalary;
	}
	public void setbasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	@Override
	 public int computeSalary() {
		return Math.round(super.computeSalary() * factor);
}
}
