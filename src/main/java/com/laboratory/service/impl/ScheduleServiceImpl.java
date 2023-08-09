package com.laboratory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.laboratory.model.Schedule;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.IScheduleRepo;
import com.laboratory.service.IScheduleService;


@Service
public class ScheduleServiceImpl extends CRUDImpl<Schedule, Integer> implements IScheduleService{

	@Autowired
	private IScheduleRepo repo;

	@Override
	protected IGenericRepo<Schedule, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	
	


}
