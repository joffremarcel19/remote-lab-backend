package com.laboratory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.laboratory.model.ScheduleTemplate;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.IScheduleTemplateRepo;
import com.laboratory.service.IScheduleTemplateService;


@Service
public class ScheduleTemplateServiceImpl extends CRUDImpl<ScheduleTemplate, Integer> implements IScheduleTemplateService{

	@Autowired
	private IScheduleTemplateRepo repo;

	@Override
	protected IGenericRepo<ScheduleTemplate, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public List<ScheduleTemplate> listbyequipment(Integer idEquipment) {
		// TODO Auto-generated method stub
		return repo.listbyequipment(idEquipment);
	}
}
