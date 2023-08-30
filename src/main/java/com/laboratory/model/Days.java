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
@Table(name="Days")
public class Days {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDay;
	@Column(name="nameDay")
	private String nameDay;
}
