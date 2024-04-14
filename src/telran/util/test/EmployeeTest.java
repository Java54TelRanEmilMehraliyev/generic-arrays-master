package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.employees.Manager;
import telran.employees.SalesPerson;
import telran.employees.WageEmployee;

public class EmployeeTest {

	@Test
	void testWageEmployeeTest() {
		long id = 1L;
		int basicSalary = 0;
		String department = "QA";
		WageEmployee employee = new WageEmployee(id,basicSalary,department,50,20);
		double expectedSalary = 1000.00;
		assertEquals(expectedSalary,employee.computeSalary(),"Salary calculation is correct");
		
	}
	@Test
	void testManagerTest() {
		long id = 21L;
		int basicSalary = 10000;
		String department = "QA";
		float factor = 1.4f;
		Manager manager = new Manager(id,basicSalary,department,factor);
	    double expectedSalary = 14000f;
	    assertEquals(expectedSalary, manager.computeSalary(),"Salary computation is correct");
	}
	@Test
	void testSalesTest() {
		long id = 122l;
		int basicSalary = 0;
		String department = "Sales";
		int hours = 180;
		int wage = 55;
		float percent = 2f;
		long sales = 35000;
		SalesPerson salesPerson = new SalesPerson(id,basicSalary,department,hours,wage,percent,sales);
		double expectedSalary = hours * wage + percent * sales;
	    assertEquals(expectedSalary, salesPerson.computeSalary(), "Salary computation is correct");
	}

}
