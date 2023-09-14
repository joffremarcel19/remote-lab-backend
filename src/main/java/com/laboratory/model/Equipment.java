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
@Table(name="equipment")
public class Equipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="ipCamera")
	private String ipCamera;
	
	@Column(name="ipEquipment")
	private String ipEquipment;
	
	@ManyToOne
	@JoinColumn(name="idLaboratory", nullable=false, foreignKey = @ForeignKey(name="FK_equipment_laboratory"))
	private Laboratory laboratory;
	
	@OneToOne(targetEntity = VideoEquipment.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "idVideo")
	private VideoEquipment videoEquipment;
	
	@OneToMany(mappedBy = "laboratoryEquipment", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Schedule> schedule;
	
	@OneToMany(mappedBy = "laboratoryEquipment", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<ScheduleTemplate> scheduleTemplate;
	
}
