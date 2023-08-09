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
@Table(name="faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFaculty;
	
	@Column(name="nameFaculty", nullable=false, length= 90)
	private String nameFaculty;
	
	@ManyToOne
	@JoinColumn(name = "idUniversity", nullable = false, foreignKey = @ForeignKey(name = "FK_faculty_university"))
	private University university;

	public Integer getIdFaculty() {
		return idFaculty;
	}

	public void setIdFaculty(Integer idFaculty) {
		this.idFaculty = idFaculty;
	}

	public String getNameFaculty() {
		return nameFaculty;
	}

	public void setNameFaculty(String nameFaculty) {
		this.nameFaculty = nameFaculty;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}	
}
