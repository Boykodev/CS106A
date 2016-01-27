import acm.program.*;

/**
 * Stores an information
 * about employees.
 */
public class Employee extends ConsoleProgram {
	
	public Employee() { this("", "", 0); }
	
	public Employee(String name, String supervisor, double salary) {
		this.name = name;
		this.supervisor = supervisor;
		this.salary = salary;
	}
	
	public void run() {
		Employee emp = new Employee();
		emp.setName("Serge");
		emp.setSupervisor("God");
		emp.setSalary(1000000);
		println(emp);
	}
	
	public String getName() { return name; }
	public String getSupervisor() { return supervisor; }
	public double getSalary() { return salary; }
	
	public void setName(String name) { this.name = name; }
	public void setSupervisor(String supervisor) { this.supervisor = supervisor; }
	public void setSalary(double salary) { this.salary = salary; }
	
	public String toString() {
		return "Name: " + name + "\nSupervisor: " + supervisor + "\nSalary: " + salary;
	}
	
	private String name;
	private String supervisor;
	private double salary;
}
