package com.laboratory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subject_id;
	@Column(name="name", nullable=false, length=70)
	private String name;
	
	@Column(name="description", nullable=false, length=150)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "school_id", nullable = false, foreignKey = @ForeignKey(name = "FK_subject_school"))
	private School school;
	
	@ManyToOne
	@JoinColumn(name = "laboratory_id", nullable = false, foreignKey = @ForeignKey(name = "FK_subject_laboratory"))
	private Laboratory laboratory;

}
