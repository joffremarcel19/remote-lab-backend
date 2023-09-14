package com.laboratory.DTO;

import java.util.List;

import com.laboratory.model.Subject;

import lombok.Data;

@Data
public class LaboratoryDTO {
	private Integer id;
	private String name;
	private String description;
	private List<DetailSubjectDTO> subjects;
}
