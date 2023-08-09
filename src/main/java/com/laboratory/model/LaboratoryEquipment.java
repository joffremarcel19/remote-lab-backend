package com.laboratory.model;

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

@Entity
@Table(name="laboratoryEquipment")
public class LaboratoryEquipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEquipment;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@OneToOne(targetEntity = LaboratoryState.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id_state")
	private LaboratoryState laboratoryState;
	
	@ManyToOne
	@JoinColumn(name="idLaboratory", nullable=false, foreignKey = @ForeignKey(name="FK_equipment_laboratory"))
	private Laboratory laboratory;
	
	public Integer getIdEquipment() {
		return idEquipment;
	}
	public void setIdEquipment(Integer idEquipment) {
		this.idEquipment = idEquipment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LaboratoryState getLaboratoryState() {
		return laboratoryState;
	}
	public void setLaboratoryState(LaboratoryState laboratoryState) {
		this.laboratoryState = laboratoryState;
	}
	public Laboratory getLaboratory() {
		return laboratory;
	}
	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}
	
}
