package com.laboratory.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laboratory.model.Laboratory;
import com.laboratory.model.Menu;

public interface ILaboratoryRepo extends IGenericRepo<Laboratory, Integer>{

	@Query(value="select l.* from laboratory l where l.id_laboratory=:idLaboratory", nativeQuery = true)
	List<Laboratory> listbyfaculty(@Param("idLaboratory") Integer idLaboratory);
}
