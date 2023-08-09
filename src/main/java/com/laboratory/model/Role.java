package com.laboratory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRole;
	@Column(name="nameRole")
	private String nameRole;
	@Column(name="descriptionRole")
	private String descriptionRole;
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	public String getDescriptionRole() {
		return descriptionRole;
	}
	public void setDescriptionRole(String descriptionRole) {
		this.descriptionRole = descriptionRole;
	}
	
	
}
