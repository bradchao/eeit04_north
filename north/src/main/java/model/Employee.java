package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeID")
	private int employeeId;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "Title")
	private String title;
	
	public Employee() {}

	public Employee(String title, 
				String firstName,
				String lastName) {
		this(0, lastName, firstName, title);
	}
	
	public Employee(Integer employeeId, String lastName,
				String firstName, String title) {
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
