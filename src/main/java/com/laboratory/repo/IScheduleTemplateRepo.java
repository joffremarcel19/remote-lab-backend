package com.laboratory.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.laboratory.model.ScheduleTemplate;

public interface IScheduleTemplateRepo extends IGenericRepo<ScheduleTemplate, Integer>{
	@Query(value="select l.* from schedule_template l where l.id_equipment=:idEquipment", nativeQuery = true)
	List<ScheduleTemplate> listbyequipment(@Param("idEquipment") Integer idEquipment);
}
