package com.laboratory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.model.Laboratory;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.ILaboratoryRepo;
import com.laboratory.service.ILaboratoryService;

@Service
public class LaboratoryServiceImpl extends CRUDImpl<Laboratory, Integer> implements ILaboratoryService{

	@Autowired
	private ILaboratoryRepo repo;

	@Override
	protected IGenericRepo<Laboratory, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public List<Laboratory> listbyfaculty(Integer idFaculty) {
		// TODO Auto-generated method stub
		return repo.listbyfaculty(idFaculty);
	}
}
