package com.laboratory.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="laboratory")
public class Laboratory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name", nullable=false, length=70)
	private String name;
	@Column(name="description", length=190)
	private String description;		

	@OneToMany(mappedBy = "laboratory", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DetailSubject> detailSubject;
}
