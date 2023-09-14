package com.laboratory.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="detailSubject")
public class DetailSubject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "subject_id", nullable = false, foreignKey = @ForeignKey(name = "FK_subject_Detail"))
	private Subject subject;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "laboratory_id", nullable = false, foreignKey = @ForeignKey(name = "FK_subject_laboratory"))
	private Laboratory laboratory;
	
}
