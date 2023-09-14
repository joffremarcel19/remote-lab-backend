package com.laboratory.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laboratory.DTO.SchoolDTO;
import com.laboratory.model.Subject;

public interface ISubjectRepo extends IGenericRepo<Subject, Integer>{
	@Query(value="select * from subject s where laboratory_id =:laboratory_id and school_id =:school_id", nativeQuery = true)
	List<Subject> listarSubject(@Param("laboratory_id") Integer laboratory_id,@Param("school_id") Integer school_id );
		
}
