package com.laboratory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.model.Equipment;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.ILaboratoryEquipmentRepo;
import com.laboratory.service.ILaboratoryEquipmentService;


@Service
public class LaboratoryEquipmentServiceImpl extends CRUDImpl<Equipment, Integer> implements ILaboratoryEquipmentService{

	@Autowired
	private ILaboratoryEquipmentRepo repo;

	@Override
	protected IGenericRepo<Equipment, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public List<Equipment> listbylaboratory(Integer idLaboratory) {
		// TODO Auto-generated method stub
		return repo.listbylaboratory(idLaboratory);
	}

	
	


}
