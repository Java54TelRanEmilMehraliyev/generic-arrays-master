package telran.employees;


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import telran.util.Arrays;
//SO far we don't consider optimization
public class Company implements Iterable{
	private Employee[] employees;
	
	public void addEmployee(Employee empl) {
		// adds new Employee to array of employees
		//if an employee with id equaled to id of empl exists, then to throw IllegalStateException
		if (findEmployeeIndexById(empl.getId()) != -1) {
	        throw new IllegalStateException("Employee with current ID " + empl.getId() + " already exists.");
	    }
	    Employee[] newEmployees = java.util.Arrays.copyOf(employees, employees.length + 1);
	    newEmployees[newEmployees.length - 1] = empl;
	    employees = newEmployees;
	}
    
	private int findEmployeeIndexById(long id) {
	    for (int i = 0; i < employees.length; i++) {
	        if (employees[i].getId() == id) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	public Employee getEmployee(long id) {
		// data about an employee with a given id value
		//if the company doesn't have such employee, then return null
	int index = findEmployeeIndexById(id);
	return index != -1 ? employees[index] : null;
	
	}
	public Employee removeEmployee(long id) {
		//removes from the company an employee with a given id
		//if such employee doesn't exist, throw NoSuchElementException
		//returns reference to being removed employee
		 int index = findEmployeeIndexById(id);
		    if (index != -1) {
		        Employee removedEmployee = employees[index];
		        Employee[] newEmployees = new Employee[employees.length - 1];
		        System.arraycopy(employees, 0, newEmployees, 0, index);
		        System.arraycopy(employees, index + 1, newEmployees, index, employees.length - index - 1);
		        employees = newEmployees;
		        return removedEmployee;
		    }
		    throw new NoSuchElementException("Employee with id " + id + " doesn't exist");
		}
	
	public int getDepartmentBudget(String department) {
		//TODO
		//returns sum of basic salary values for all employees of a given department
		//if employees of a given department don't exist, returns 0
		int total = 0;
		for(Employee employee : employees) {
			if(employee.getDepartment().equals(department)) {
				total += employee.getBasicSalary();
			}
		}
		return total;
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
	    private int index = 0;

	    public CompanyIterator() {
	        Comparator<Employee> employeeIdComparator = new Comparator<Employee>() {
	            @Override
	            public int compare(Employee e1, Employee e2) {
	                return Long.compare(e1.getId(), e2.getId());
	            }
	        };
	        Arrays.bubbleSort(employees, employeeIdComparator);
	    }

	    @Override
	    public boolean hasNext() {
	        return index < employees.length;
	    }

	    @Override
	    public Employee next() {
	        if (!hasNext()) {
	            throw new NoSuchElementException();
	        }
	        return employees[index++];
	    }
	}
}