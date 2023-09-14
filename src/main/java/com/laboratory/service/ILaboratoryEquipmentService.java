package com.laboratory.service;

import java.util.List;

import com.laboratory.model.Equipment;

public interface ILaboratoryEquipmentService extends ICRUD<Equipment, Integer>{
	List<Equipment> listbylaboratory(Integer idLaboratory);
}
