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
@Table(name="dayEquipment")
public class DayEquipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDayLaboratory;
	
	@ManyToOne
	@JoinColumn(name = "idDay", nullable = false, foreignKey =@ForeignKey(name = "FK_Laboratory_Day"))
	private Days days;
	
	@ManyToOne
	@JoinColumn(name = "idTime", nullable = false, foreignKey =@ForeignKey(name = "FK_Laboratory_Time"))
	private TimeLaboratory timeLaboratory;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_laboratoryEquiment", nullable = false, foreignKey = @ForeignKey(name = "FK_Equipment_days"))
	private LaboratoryEquipment laboratoryEquipment;

}
