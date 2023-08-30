package com.laboratory.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.laboratory.model.LaboratoryEquipment;

public interface ILaboratoryEquipmentRepo extends IGenericRepo<LaboratoryEquipment, Integer>{
	@Query(value="select l.* from laboratory_equipment l where l.id_laboratory=:idLaboratory", nativeQuery = true)
	List<LaboratoryEquipment> listbylaboratory(@Param("idLaboratory") Integer idLaboratory);
		
}
