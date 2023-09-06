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
@Table(name="university")
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer university_id;
	@Column(name="name", nullable=false, length = 90)
	private String name;
}
