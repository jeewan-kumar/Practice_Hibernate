package com.passpoart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Passport {
	@Id
	private Long id;
	private String passportNumber;
	@OneToOne
	private PassportDetail passportDetail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public PassportDetail getPassportDetail() {
		return passportDetail;
	}
	public void setPassportDetail(PassportDetail passportDetail) {
		this.passportDetail = passportDetail;
	}
	
}
