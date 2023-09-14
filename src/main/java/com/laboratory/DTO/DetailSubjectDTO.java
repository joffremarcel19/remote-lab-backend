package com.laboratory.DTO;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laboratory.model.Laboratory;
import com.laboratory.model.Subject;

import lombok.Data;

@Data
public class DetailSubjectDTO {

	private Integer id;
	
	private List<Subject> subject;
	
	private Laboratory laboratory;
}
