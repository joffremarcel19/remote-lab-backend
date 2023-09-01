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
@Table(name="scheduleStatus")
public class ScheduleStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idScheduleStatus;
	
	@Column(name="name")
	private String name;
}
