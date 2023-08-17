package com.laboratory.service;

import java.util.List;

import com.laboratory.model.Laboratory;

public interface ILaboratoryService extends ICRUD<Laboratory, Integer>{
	List<Laboratory> listbyfaculty(Integer idFaculty);
}
