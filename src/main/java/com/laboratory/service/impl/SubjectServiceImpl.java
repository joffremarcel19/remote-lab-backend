package com.laboratory.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.model.Subject;
import com.laboratory.repo.ISubjectRepo;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.service.ISubjectService;

@Service
public class SubjectServiceImpl extends CRUDImpl<Subject, Integer> implements ISubjectService{

	@Autowired
	private ISubjectRepo repo;

	@Override
	protected IGenericRepo<Subject, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public List<Subject> listarSubject(Integer laboratory_id, Integer school_id) {
		// TODO Auto-generated method stub
		return repo.listarSubject(laboratory_id, school_id);
	}

	
	


}
