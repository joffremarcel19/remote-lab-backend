package com.laboratory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="laboratoryState")
public class LaboratoryState {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idState;
	@Column(name="stateName", nullable=false, length=80)
	private String stateName;
	public Integer getIdState() {
		return idState;
	}
	public void setIdState(Integer idState) {
		this.idState = idState;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}	
}
