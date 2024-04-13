package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.employees.Company;
import telran.employees.Employee;

class CompanyTest {
private static final long ID1 = 123;
private static final int SALARY1 = 1000;
private static final String DEPARTMENT1 = "Development";
private static final long ID2 = 120;
private static final int SALARY2 = 2000;
private static final long ID3 = 125;
private static final int SALARY3 = 3000;
private static final String DEPARTMENT2 = "QA";
Employee empl1 = new Employee(ID1, SALARY1, DEPARTMENT1);
Employee empl2 = new Employee(ID2, SALARY2, DEPARTMENT1);
Employee empl3 = new Employee(ID3, SALARY3, DEPARTMENT2);
Company company;
@BeforeEach
void setCompany() {
	//before each test there will be created new object company 
	// with array of the given employee objects
	company = new Company(new Employee[] {empl1, empl2, empl3});
}
	@Test
	void testAddEmployee() {
		Employee newEmployee = new Employee(900L,1500,"FrontOffice");
		company.addEmployee(newEmployee);
		assertEquals(newEmployee,company.getEmployee(900L));
		assertThrowsExactly(IllegalStateException.class,
				() -> company.addEmployee(newEmployee));
	}

	@Test
	void testGetEmployee() {
		assertEquals(empl1,company.getEmployee(ID1));
		assertEquals(empl2,company.getEmployee(ID2));
		assertEquals(empl3,company.getEmployee(ID3));
		assertNull(company.getEmployee(900l));
	}

	@Test
	void testRemoveEmployee() {
		assertEquals(empl1,company.removeEmployee(ID1));
		assertThrows(NoSuchElementException.class,
				() -> company.removeEmployee(900L));
		assertThrows(NoSuchElementException.class, 
				() -> company.removeEmployee(ID1));
	}

	@Test
	void testGetDepartmentBudget() {
		assertEquals(SALARY1 + SALARY2,company.getDepartmentBudget(DEPARTMENT1));
		assertEquals(0, company.getDepartmentBudget("Electra Maliyot"));
	}

	@Test
	void testIterator() {
		Iterator<Employee> iterator = company.iterator();
		assertTrue(iterator.hasNext());
		assertEquals(empl2, iterator.next());
		
		assertTrue(iterator.hasNext());
		assertEquals(empl1, iterator.next());
		
		assertTrue(iterator.hasNext());
		assertEquals(empl3, iterator.next());
		
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> iterator.next());
	}

}