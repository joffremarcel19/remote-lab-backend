package com.laboratory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="videoEquipment")
public class VideoEquipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVideo;	
	@Column(name="title")
	private String title;
	@Column(name="url")
	private String url;
	
}
