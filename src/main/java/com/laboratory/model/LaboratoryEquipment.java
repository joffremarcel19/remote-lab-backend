package com.laboratory.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
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
	@OneToMany(mappedBy = "laboratoryEquipment", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DayEquipment> dayLaboratory;	
	@OneToOne(targetEntity = VideoEquipment.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "idVideo")
	private VideoEquipment videoEquipment;		
}
