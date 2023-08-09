package com.laboratory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="university")
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUniversity;
	@Column(name="nameUniversity", nullable=false, length = 90)
	private String nameUniversity;
	
	
	public Integer getIdUniversity() {
		return idUniversity;
	}
	public void setIdUniversity(Integer idUniversity) {
		this.idUniversity = idUniversity;
	}
	public String getNameUniversity() {
		return nameUniversity;
	}
	public void setNameUniversity(String nameUniversity) {
		this.nameUniversity = nameUniversity;
	}
}
