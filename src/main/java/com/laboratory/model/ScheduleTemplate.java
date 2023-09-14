package com.laboratory.model;

import java.time.LocalTime;

import javax.persistence.Column;
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
@Table(name="scheduleTemplate")
public class ScheduleTemplate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idEquipment", nullable = false, foreignKey = @ForeignKey(name = "FK_Schedule_Equipment"))
	private Equipment laboratoryEquipment;	
	
	@Column(name="day")
	private String day;
	
	@Column(name="start")	
	private LocalTime start;
	
	@Column(name="end")
	private LocalTime end;	
}
