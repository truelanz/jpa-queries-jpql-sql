package com.devsuperior.bee2737.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lawyers")
public class Lawyer {

	@Id
	private Long register;
	private String name;
	@Column(name = "customers_number")
	private Integer customersNumber;
	
	public Lawyer() {
	}

	public Long getRegister() {
		return register;
	}

	public void setRegister(Long register) {
		this.register = register;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCustomersNumber() {
		return customersNumber;
	}

	public void setCustomersNumber(Integer customersNumber) {
		this.customersNumber = customersNumber;
	}
}
