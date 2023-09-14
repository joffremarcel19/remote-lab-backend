package com.laboratory.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(name="fromDate")
	private LocalDateTime fromDate;
	
	@Column(name="toDate")
	private LocalDateTime toDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idEquipment", nullable = false, foreignKey = @ForeignKey(name = "FK_Schedule_Laboratory"))
	private Equipment laboratoryEquipment;
		
	@OneToOne(targetEntity = ScheduleStatus.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "idScheduleStatus")
	private ScheduleStatus scheduleStatus;	
	
	
	
}
