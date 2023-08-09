package com.laboratory.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.model.Asignature;
import com.laboratory.repo.IAsignatureRepo;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.service.IAsignatureService;

@Service
public class AsignatureServiceImpl extends CRUDImpl<Asignature, Integer> implements IAsignatureService{

	@Autowired
	private IAsignatureRepo repo;

	@Override
	protected IGenericRepo<Asignature, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	
	


}
