package com.laboratory.service;

import java.util.List;

import com.laboratory.model.School;
import com.laboratory.model.Subject;

public interface ISubjectService extends ICRUD<Subject, Integer>{
	List<Subject> listarSubject(Integer laboratory_id,Integer school_id);
}
