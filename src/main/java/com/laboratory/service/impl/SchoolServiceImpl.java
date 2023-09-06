package com.laboratory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.DTO.SchoolDTO;
import com.laboratory.model.School;
import com.laboratory.repo.ISchoolRepo;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.service.ISchoolService;


@Service
public class SchoolServiceImpl extends CRUDImpl<School, Integer> implements ISchoolService{

	@Autowired
	private ISchoolRepo repo;

	@Override
	protected IGenericRepo<School, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public List<SchoolDTO> listarSchool() {
		// TODO Auto-generated method stub
		return repo.listarSchool();
	}

	
	


}
