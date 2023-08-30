package com.laboratory.service;

import java.util.List;

import com.laboratory.model.LaboratoryEquipment;

public interface ILaboratoryEquipmentService extends ICRUD<LaboratoryEquipment, Integer>{
	List<LaboratoryEquipment> listbylaboratory(Integer idLaboratory);
}
