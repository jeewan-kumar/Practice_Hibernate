package com.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class EmployeeDetail {
	@Id
	private int employeeDetail;
	private String address;
	private String phone;
	@OneToOne
	private Employee employee;
	public int getEmployeeDetail() {
		return employeeDetail;
	}
	public void setEmployeeDetail(int employeeDetail) {
		this.employeeDetail = employeeDetail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
