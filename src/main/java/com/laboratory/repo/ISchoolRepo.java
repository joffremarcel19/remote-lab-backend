package com.laboratory.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laboratory.DTO.SchoolDTO;
import com.laboratory.model.Menu;
import com.laboratory.model.School;

public interface ISchoolRepo extends IGenericRepo<School, Integer>{
	@Query(value="select * from school", nativeQuery = true)
	List<SchoolDTO> listarSchool();
}
