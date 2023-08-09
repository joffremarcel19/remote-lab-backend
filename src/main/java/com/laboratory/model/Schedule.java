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
	
	public Integer getIdSchedule() {
		return idSchedule;
	}
	public void setIdSchedule(Integer idSchedule) {
		this.idSchedule = idSchedule;
	}
	public LaboratoryEquipment getLaboratoryEquipment() {
		return laboratoryEquipment;
	}
	public void setLaboratoryEquipment(LaboratoryEquipment laboratoryEquipment) {
		this.laboratoryEquipment = laboratoryEquipment;
	}
	public LocalDateTime getAttentionDate() {
		return attentionDate;
	}
	public void setAttentionDate(LocalDateTime attentionDate) {
		this.attentionDate = attentionDate;
	}
	public LocalTime getAttentionStart() {
		return attentionStart;
	}
	public void setAttentionStart(LocalTime attentionStart) {
		this.attentionStart = attentionStart;
	}
	public LocalTime getAttentionEnd() {
		return attentionEnd;
	}
	public void setAttentionEnd(LocalTime attentionEnd) {
		this.attentionEnd = attentionEnd;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public LocalDateTime getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(LocalDateTime recordDate) {
		this.recordDate = recordDate;
	}
}
