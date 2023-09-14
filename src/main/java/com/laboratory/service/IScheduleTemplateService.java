package com.laboratory.service;

import java.util.List;

import com.laboratory.model.Equipment;
import com.laboratory.model.ScheduleTemplate;

public interface IScheduleTemplateService extends ICRUD<ScheduleTemplate, Integer>{
	List<ScheduleTemplate> listbyequipment(Integer idEquipment);
}
