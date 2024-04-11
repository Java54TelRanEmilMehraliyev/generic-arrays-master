package telran.employees;

import java.util.Iterator;

import telran.util.Arrays;
//SO far we don't consider optimization
public class Company implements Iterable{
	private Employee[] employees;
	public void addEmployee(Employee empl) {
		// adds new Employee to array of employees
		//if an employee with id equaled to id of empl exists, then to throw IllegalStateException
		for(Employee employee : employees) {
			if(employee.getId() == empl.getId()) {
				throw new IllegalStateException("Employee with current ID" + empl.getId() + "already exist.");
			}
		}
		Employee[]newEmployees = java.util.Arrays.copyOf(employees,employees.length + 1);
		newEmployees[newEmployees.length -1] = empl;
		employees = newEmployees;
	}
	
	public Employee getEmployee(long id) {
		// data about an employee with a given id value
		//if the company doesn't have such employee, then return null
		Employee result = null;
		for(Employee employee : employees) {
			if(employee.getId() == id) {
				result = employee;
				break;
			}
		}
		return result;
	}
	
	public Employee removeEmployee(long id) {
		//TODO
		//removes from the company an employee with a given id
		//if such employee doesn't exist, throw NoSuchElementException
		//returns reference to being removed employee
		return null;
	}
	public int getDepartmentBudget(String department) {
		//TODO
		//returns sum of basic salary values for all employees of a given department
		//if employees of a given department don't exist, returns 0
		return -1;
	}
	public Company(Employee[] employees) {
		this.employees = Arrays.copy(employees);
	}
	public String[] getDepartments(){
		//TODO
		//write method returning all departments
		return null;
	}
	
	
	@Override
	public Iterator<Employee> iterator() {
		
		return new CompanyIterator();
	}
	private class CompanyIterator implements Iterator<Employee> {
         //TODO
		//iterating all employees in the ascending order of the ID values
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Employee next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}