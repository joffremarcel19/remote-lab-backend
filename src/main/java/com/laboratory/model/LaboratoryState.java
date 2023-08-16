package com.laboratory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="laboratoryState")
public class LaboratoryState {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idState;
	@Column(name="stateName", nullable=false, length=80)
	private String stateName;	
}
