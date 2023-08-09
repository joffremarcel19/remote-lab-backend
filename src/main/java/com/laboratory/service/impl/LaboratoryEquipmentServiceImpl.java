package com.laboratory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.model.LaboratoryEquipment;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.ILaboratoryEquipmentRepo;
import com.laboratory.service.ILaboratoryEquipmentService;


@Service
public class LaboratoryEquipmentServiceImpl extends CRUDImpl<LaboratoryEquipment, Integer> implements ILaboratoryEquipmentService{

	@Autowired
	private ILaboratoryEquipmentRepo repo;

	@Override
	protected IGenericRepo<LaboratoryEquipment, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	
	


}
