package com.laboratory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.model.Faculty;
import com.laboratory.repo.IFacultyRepo;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.service.IFacultyService;


@Service
public class FacultyServiceImpl extends CRUDImpl<Faculty, Integer> implements IFacultyService{

	@Autowired
	private IFacultyRepo repo;

	@Override
	protected IGenericRepo<Faculty, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	
	


}
