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
@Table(name="TimeLaboratory")
public class TimeLaboratory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTime;
	@Column(name="startTime")
	private String startTime;
	@Column(name="endTime")
	private String endTime;
	
}
