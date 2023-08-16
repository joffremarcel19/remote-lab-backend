package com.laboratory.model;

import java.time.LocalDateTime;
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

import lombok.Data;

@Data
@Entity
@Table(name="schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSchedule;	
	@ManyToOne
	@JoinColumn(name="idEquipment", nullable=false, foreignKey = @ForeignKey(name="FK_Equipment_schedule"))
	private LaboratoryEquipment laboratoryEquipment;
	@Column(name="attentionDate")
	private LocalDateTime attentionDate;
	@Column(name="attentionStart")
	private LocalTime attentionStart;
	@Column(name="attentionEnd")
	private LocalTime attentionEnd;
	@Column(name="active")
	private boolean active;
	@Column(name="recordDate")
	private LocalDateTime recordDate;
	
}
