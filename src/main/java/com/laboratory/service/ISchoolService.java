package com.laboratory.service;

import java.util.List;

import com.laboratory.DTO.SchoolDTO;
import com.laboratory.model.School;

public interface ISchoolService extends ICRUD<School, Integer>{	
	List<SchoolDTO> listarSchool();
}
