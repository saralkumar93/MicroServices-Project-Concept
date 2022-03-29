package com.vaccinationcenter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class VaccinationCenter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String centerName;
	private String centerAddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	public VaccinationCenter(int id, String centerName, String centerAddress) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerAddress = centerAddress;
	}
	public VaccinationCenter() {
		
		// TODO Auto-generated constructor stub
	}
	
	

}
