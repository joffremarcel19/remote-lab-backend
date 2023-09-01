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
	private Integer IdScheduleTemplate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idEquipment", nullable = false, foreignKey = @ForeignKey(name = "FK_Schedule_Equipment"))
	private LaboratoryEquipment laboratoryEquipment;	
	@Column(name="dayTemplate")
	private String dayTemplate;
	@Column(name="startTemplate")
	private LocalTime startTemplate;
	@Column(name="endTemplate")
	private LocalTime endTemplate;
}
