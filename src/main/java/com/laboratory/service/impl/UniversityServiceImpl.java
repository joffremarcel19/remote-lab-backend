package com.laboratory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.laboratory.model.University;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.IUniversityRepo;
import com.laboratory.service.IUniversityService;


@Service
public class UniversityServiceImpl extends CRUDImpl<University, Integer> implements IUniversityService{

	@Autowired
	private IUniversityRepo repo;

	@Override
	protected IGenericRepo<University, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	
	


}
