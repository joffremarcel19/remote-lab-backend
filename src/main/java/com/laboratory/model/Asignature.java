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

@Entity
@Table(name="asignature")
public class Asignature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAsignature;
	@Column(name="asignatureName", nullable=false, length=70)
	private String asignatureName;
	
	@ManyToOne
	@JoinColumn(name = "idFaculty", nullable = false, foreignKey = @ForeignKey(name = "FK_asignature_faculty"))
	private Faculty faculty;

	public Integer getIdAsignature() {
		return idAsignature;
	}

	public void setIdAsignature(Integer idAsignature) {
		this.idAsignature = idAsignature;
	}

	public String getAsignatureName() {
		return asignatureName;
	}

	public void setAsignatureName(String asignatureName) {
		this.asignatureName = asignatureName;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}}
