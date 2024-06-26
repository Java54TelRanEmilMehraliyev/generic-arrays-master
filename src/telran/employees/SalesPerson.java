package telran.employees;

public class SalesPerson extends WageEmployee {
	//Constructor of class SalesPerson must take additional parameters (see UML schema)
	private float percent;
	private long sales;
	
	public SalesPerson(long id, int basicSalary, String department, int hours, int wage,float percent,long sales) {
		super(id, basicSalary, department, hours, wage);
		this.percent = percent;
		this.sales = sales;
	}
	public float getPercent() {
		return percent;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	public long getSales() {
		return sales;
	}
    public void setSales (long sales) {
    	this.sales = sales;
    }
    public int computeSalary() {
    	return super.computeSalary() + Math.round(percent * sales);
    }
}